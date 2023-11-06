package com.harusame.bossrecruitment.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.harusame.bossrecruitment.common.constant.RedisKeyConst;
import com.harusame.bossrecruitment.common.utils.JWTUtils;
import com.harusame.bossrecruitment.domain.dto.LoginDTO;
import com.harusame.bossrecruitment.domain.pojo.Balance;
import com.harusame.bossrecruitment.domain.pojo.Boss;
import com.harusame.bossrecruitment.domain.pojo.User;
import com.harusame.bossrecruitment.exception.BusinessException;
import com.harusame.bossrecruitment.mapper.BalanceMapper;
import com.harusame.bossrecruitment.mapper.BossMapper;
import com.harusame.bossrecruitment.mapper.UserMapper;
import com.harusame.bossrecruitment.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ggzst
 * @description 针对表【t_user(用户表)】的数据库操作Service实现
 * @createDate 2023-11-04 19:45:17
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private BossMapper bossMapper;
    @Resource
    private JWTUtils jwtUtils;
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private BalanceMapper balanceMapper;

    @Override
    public void updateUser(String id, Object object) {
        User user = new User();
        user.setId(Integer.valueOf(id));
        BeanUtils.copyProperties(object, user);
        userMapper.updateById(user);
    }

    @Override
    public String loginOrRegister(LoginDTO loginDTO) {
        String key = String.format(RedisKeyConst.USER_LOGIN_CAPTCHA, loginDTO.getCAPTCHA());
        Long expire = stringRedisTemplate.getExpire(key);
        if (expire != null && expire < 0) {
            throw new BusinessException("验证码无效或已过期");
        }
        stringRedisTemplate.delete(key);
        User u = userMapper.selectOne(new QueryWrapper<User>().eq("phone", loginDTO.getPhone()).select("id"));
        if (u != null) {
            Boss boss = bossMapper.selectOne(new QueryWrapper<Boss>().eq("user_id", u.getId()).select("id"));
            if (boss != null) {
                return jwtUtils.generateToken(u.getId().toString(), boss.getId().toString());
            }
            return jwtUtils.generateToken(u.getId().toString());
        }

        //如果是新用户则注册
        User user = new User();
        user.setPhone(loginDTO.getPhone());
        userMapper.insert(user);
        //初始化用户余额
        Balance balance = new Balance();
        balance.setUserId(user.getId());
        balanceMapper.insert(balance);
        return jwtUtils.generateToken(user.getId().toString());
    }


}




