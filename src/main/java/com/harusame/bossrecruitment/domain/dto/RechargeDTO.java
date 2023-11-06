package com.harusame.bossrecruitment.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@ApiModel("充值请求对象")
@Data
public class RechargeDTO {
    @ApiModelProperty(value = "充值金额", example = "100")
    @NotNull
    private BigDecimal money;
}
