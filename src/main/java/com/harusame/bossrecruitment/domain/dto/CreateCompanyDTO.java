package com.harusame.bossrecruitment.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@ApiModel("创建公司请求对象")
@Data
public class CreateCompanyDTO {
    @ApiModelProperty(value = "公司名", example = "舞鹤镇守府")
    @NotBlank
    private String companyName;

}
