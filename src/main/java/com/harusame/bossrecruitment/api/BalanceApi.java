package com.harusame.bossrecruitment.api;

import com.harusame.bossrecruitment.domain.dto.RechargeDTO;
import com.harusame.bossrecruitment.domain.pojo.Result;
import com.harusame.bossrecruitment.domain.vo.RecordVo;
import com.harusame.bossrecruitment.service.BalanceService;
import com.harusame.bossrecruitment.service.RecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@Api(tags = "余额Api")
@RestController
@RequestMapping("/api/v1/balance")
public class BalanceApi {
    @Resource
    private BalanceService balanceService;
    @Resource
    private RecordService recordService;

    @ApiOperation("余额充值")
    @PostMapping("/recharge")
    public Result recharge(@ApiParam(name = "token", value = "身份认证令牌")
                           @RequestHeader String token, @RequestBody @Valid RechargeDTO rechargeDTO) {
        balanceService.recharge(rechargeDTO);
        return Result.successMsg("充值成功");
    }

    @ApiOperation("查询余额")
    @PostMapping("/viewBalance")
    public Result viewBalance(@ApiParam(name = "token", value = "身份认证令牌")
                              @RequestHeader String token) {
        return Result.success(balanceService.viewBalance());
    }

    @ApiOperation("查看账单明细")
    @PostMapping("/viewRecords")
    public Result viewBill(@ApiParam(name = "token", value = "身份认证令牌")
                           @RequestHeader String token) {
        RecordVo recordVo = recordService.viewRecords();
        return Result.success(recordVo);
    }
}
