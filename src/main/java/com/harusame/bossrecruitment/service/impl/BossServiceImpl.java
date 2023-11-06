package com.harusame.bossrecruitment.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.harusame.bossrecruitment.common.utils.TokenUtils;
import com.harusame.bossrecruitment.domain.dto.CreateBossDTO;
import com.harusame.bossrecruitment.domain.dto.CreateSeekerDTO;
import com.harusame.bossrecruitment.domain.pojo.Boss;
import com.harusame.bossrecruitment.domain.pojo.Company;
import com.harusame.bossrecruitment.domain.pojo.Seeker;
import com.harusame.bossrecruitment.domain.pojo.User;
import com.harusame.bossrecruitment.exception.BusinessException;
import com.harusame.bossrecruitment.mapper.CompanyMapper;
import com.harusame.bossrecruitment.mapper.UserMapper;
import com.harusame.bossrecruitment.service.BossService;
import com.harusame.bossrecruitment.mapper.BossMapper;
import com.harusame.bossrecruitment.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author ggzst
 * @description 针对表【t_boss(BOSS表)】的数据库操作Service实现
 * @createDate 2023-11-04 19:45:17
 */
@Service
public class BossServiceImpl extends ServiceImpl<BossMapper, Boss>
        implements BossService {
    @Resource
    private CompanyMapper companyMapper;
    @Resource
    private BossMapper bossMapper;
    @Resource
    private UserService userService;
    @Resource
    private TokenUtils tokenUtils;

    @Override
    @Transactional
    public void createBoss(CreateBossDTO createBossDTO) {
        String id = tokenUtils.getUserIdFromHeader();
        userService.updateUser(id, createBossDTO);
        String companyName = createBossDTO.getCompanyName();
        Company company = companyMapper.selectOne(new QueryWrapper<Company>().eq("company_name", companyName).select("id"));
        if (company == null) {
            throw new BusinessException("输入的公司不存在");
        }
        Boss boss = new Boss();
        boss.setUserId(Integer.valueOf(id));
        BeanUtils.copyProperties(createBossDTO, boss);
        boss.setCompanyId(company.getId());
        bossMapper.insert(boss);
    }


}




