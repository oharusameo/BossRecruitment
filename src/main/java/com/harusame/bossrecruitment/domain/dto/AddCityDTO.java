package com.harusame.bossrecruitment.domain.dto;

import com.harusame.bossrecruitment.domain.pojo.City;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@ApiModel("添加城市请求对象")
public class AddCityDTO {

    @NotNull
    @ApiModelProperty(value = "城市名称", example = "['广州','北京','上海','深圳']")
    private List<String> cities;
}
