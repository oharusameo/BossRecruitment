package com.harusame.bossrecruitment.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.harusame.bossrecruitment.domain.pojo.CompanyBoss;
import com.harusame.bossrecruitment.service.CompanyBossService;
import com.harusame.bossrecruitment.mapper.CompanyBossMapper;
import org.springframework.stereotype.Service;

/**
* @author ggzst
* @description 针对表【t_company_boss(公司boss中间表)】的数据库操作Service实现
* @createDate 2023-11-04 19:45:17
*/
@Service
public class CompanyBossServiceImpl extends ServiceImpl<CompanyBossMapper, CompanyBoss>
    implements CompanyBossService{

}




