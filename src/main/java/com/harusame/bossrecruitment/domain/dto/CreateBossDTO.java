package com.harusame.bossrecruitment.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@ApiModel("创建BOSS请求对象")
@Data
public class CreateBossDTO {
    @ApiModelProperty(value = "名字", example = "yamato")
    @NotBlank
    private String name;
    @ApiModelProperty(value = "性别", example = "2")
    @NotNull
    private Integer gender;
    @ApiModelProperty(value = "身份", example = "1")
    @NotNull
    private Integer role;
/*    @ApiModelProperty(value = "生日", example = "yyyy-MM-dd")
    @NotNull
    private Date birthday;*/
    @ApiModelProperty(value = "公司名称", example = "舞鹤镇守府")
    @NotBlank
    private String companyName;

}
