package com.harusame.bossrecruitment.service;

import com.harusame.bossrecruitment.domain.dto.CreateCompanyDTO;
import com.harusame.bossrecruitment.domain.pojo.Company;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author ggzst
* @description 针对表【t_company(公司表)】的数据库操作Service
* @createDate 2023-11-04 19:45:17
*/
public interface CompanyService extends IService<Company> {

    void createCompany(CreateCompanyDTO createCompanyDTO);
}
