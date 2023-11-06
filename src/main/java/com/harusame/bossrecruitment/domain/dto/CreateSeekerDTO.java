package com.harusame.bossrecruitment.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@ApiModel("创建求职者请求对象")
@Data
public class CreateSeekerDTO {
    @ApiModelProperty(value = "名字", example = "harusame")
    @NotBlank
    private String name;
    @ApiModelProperty(value = "性别", example = "1")
    @NotNull
    private Integer gender;
    @ApiModelProperty(value = "身份", example = "2")
    @NotNull
    private Integer role=2;
    @ApiModelProperty(value = "理想的工作城市", example = "1")
    private Integer cityId;
    @ApiModelProperty("生日")
    @NotNull
    private Date birthday;
    @ApiModelProperty(value = "牛人身份", example = "1")
    @NotNull
    private Integer identity;
    @ApiModelProperty(value = "求职状态", example = "1")
    @NotNull
    private Integer availability;
    @ApiModelProperty(value = "学历", example = "5")
    @NotNull
    private Integer level;
    @ApiModelProperty(value = "是否全职", example = "true")
    @NotNull
    private Boolean fullTime;
    @ApiModelProperty(value = "毕业院校", example = "麻章理工大学")
    @NotBlank
    private String schoolName;
    @ApiModelProperty(value = "专业", example = "数据科学与大数据技术")
    @NotBlank
    private String major;
    @ApiModelProperty("首次参加工作时间")
    private Date firstEmployedDate;
    @ApiModelProperty(value = "入学时间", example = "yyyy-MM-dd")
    @NotNull
    private Date startTime;
    @ApiModelProperty(value = "毕业时间", example = "yyyy-MM-dd")
    @NotNull
    private Date endTime;
    @ApiModelProperty(value = "期望职位", example = "jvav开发")
    @NotBlank
    private String position;

}
