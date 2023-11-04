package com.harusame.bossrecruitment.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.harusame.bossrecruitment.domain.pojo.User;
import com.harusame.bossrecruitment.service.UserService;
import com.harusame.bossrecruitment.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author ggzst
* @description 针对表【t_user(用户表)】的数据库操作Service实现
* @createDate 2023-11-04 19:45:17
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




