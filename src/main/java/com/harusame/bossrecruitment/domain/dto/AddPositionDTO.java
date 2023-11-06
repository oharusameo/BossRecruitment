package com.harusame.bossrecruitment.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel("添加职位请求对象")
@Data
public class AddPositionDTO {
    @ApiModelProperty(value = "职位名称", example = "jvav开发")
    @NotBlank
    private String name;
    @ApiModelProperty(value = "工作经验", example = "4")
    @NotNull
    private Integer experience;
    @ApiModelProperty(value = "工作类型", example = "1")
    @NotNull
    private Integer workType;
    @ApiModelProperty(value = "薪资范围", example = "10k")
    @NotBlank
    private String salaryBottom;
    @ApiModelProperty(value = "薪资范围", example = "15k")
    @NotBlank
    private String salaryTop;
    @ApiModelProperty(value = "学历要求", example = "5")
    @NotNull
    private Integer level;
    @ApiModelProperty(value = "专业要求", example = "数据科学与大数据技术")
    @NotBlank
    private String major;
    @ApiModelProperty(value = "工作地点", example = "天河区体育西路上盖")
    @NotBlank
    private String location;
    @ApiModelProperty(value = "工作城市", example = "1")
    @NotNull
    private Integer cityId;



}
