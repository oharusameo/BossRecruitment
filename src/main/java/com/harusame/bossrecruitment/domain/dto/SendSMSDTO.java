package com.harusame.bossrecruitment.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@ApiModel("发送短信请求对象")
@Data
public class SendSMSDTO {
    @ApiModelProperty("手机号")
    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = "^0?(13|15|18|19)[0-9]{9}$", message = "手机格式不符合条件")
    private String phone;
}
