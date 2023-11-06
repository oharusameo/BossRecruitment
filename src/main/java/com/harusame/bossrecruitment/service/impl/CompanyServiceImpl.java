package com.harusame.bossrecruitment.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.harusame.bossrecruitment.common.utils.TokenUtils;
import com.harusame.bossrecruitment.domain.dto.CreateCompanyDTO;
import com.harusame.bossrecruitment.domain.pojo.Company;
import com.harusame.bossrecruitment.exception.BusinessException;
import com.harusame.bossrecruitment.service.CompanyService;
import com.harusame.bossrecruitment.mapper.CompanyMapper;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.C;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ggzst
 * @description 针对表【t_company(公司表)】的数据库操作Service实现
 * @createDate 2023-11-04 19:45:17
 */
@Service
@Slf4j
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company>
        implements CompanyService {
    @Resource
    private CompanyMapper companyMapper;


    @Override
    public void createCompany(CreateCompanyDTO createCompanyDTO) {
        String companyName = createCompanyDTO.getCompanyName();
        Company company = companyMapper.selectOne(new QueryWrapper<Company>().eq("company_name", companyName));
        if (company != null) {
            throw new BusinessException("创建公司失败，公司已存在");
        }
        companyMapper.insert(new Company(companyName));
    }
}




