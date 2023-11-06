package com.harusame.bossrecruitment.api;

import com.harusame.bossrecruitment.common.annotation.RequireLogin;
import com.harusame.bossrecruitment.domain.dto.CreateBossDTO;
import com.harusame.bossrecruitment.domain.dto.CreateCompanyDTO;
import com.harusame.bossrecruitment.domain.dto.CreateSeekerDTO;
import com.harusame.bossrecruitment.domain.pojo.Result;
import com.harusame.bossrecruitment.service.BossService;
import com.harusame.bossrecruitment.service.CompanyService;
import com.harusame.bossrecruitment.service.SeekerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@Api(tags = "注册接口", value = "RegisterApi")
@RequestMapping("/api/v1/register")
@RestController
public class RegisterApi {
    @Resource
    private SeekerService seekerService;
    @Resource
    private BossService bossService;
    @Resource
    private CompanyService companyService;

    @PostMapping("/createSeeker")
    @ApiOperation("创建求职者")
    @RequireLogin
    public Result createSeeker(@ApiParam(name = "token", value = "身份认证令牌")
                               @RequestHeader String token,
                               @RequestBody @Valid CreateSeekerDTO createSeekerDTO) {
        seekerService.createSeeker(createSeekerDTO);
        return Result.successMsg("创建求职者成功");
    }

    @PostMapping("/createBoss")
    @ApiOperation("创建Boss")
    @RequireLogin
    public Result createBoss(@ApiParam(name = "token", value = "身份认证令牌")
                             @RequestHeader String token,
                             @RequestBody @Valid CreateBossDTO createBossDTO) {
        bossService.createBoss(createBossDTO);
        return Result.successMsg("创建Boss成功");
    }

    @PostMapping("/createCompany")
    @ApiOperation("创建公司")
    public Result createCompany(@RequestBody @Valid CreateCompanyDTO createCompanyDTO) {
        companyService.createCompany(createCompanyDTO);
        return Result.successMsg("创建公司成功");
    }
}
