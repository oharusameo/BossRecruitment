package com.harusame.bossrecruitment.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ApiModel("查询余额对象")
public class BalanceVo {
    @ApiModelProperty("用户id")
    private Integer userId;
    @ApiModelProperty("余额")
    private BigDecimal balance;
}
