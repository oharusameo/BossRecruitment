package com.harusame.bossrecruitment.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.harusame.bossrecruitment.domain.pojo.Company;
import com.harusame.bossrecruitment.service.CompanyService;
import com.harusame.bossrecruitment.mapper.CompanyMapper;
import org.springframework.stereotype.Service;

/**
* @author ggzst
* @description 针对表【t_company(公司表)】的数据库操作Service实现
* @createDate 2023-11-04 19:45:17
*/
@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company>
    implements CompanyService{

}




