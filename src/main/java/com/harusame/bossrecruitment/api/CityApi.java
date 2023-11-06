package com.harusame.bossrecruitment.api;

import com.harusame.bossrecruitment.domain.dto.AddCityDTO;
import com.harusame.bossrecruitment.domain.pojo.Result;
import com.harusame.bossrecruitment.service.CityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@Api(tags = "城市接口", value = "CityApi")
@RestController
@RequestMapping("/api/v1/city")
public class CityApi {
    @Resource
    private CityService cityService;

    @PostMapping("/addCity")
    @ApiOperation("添加城市")
    public Result addCity(@RequestBody @Valid AddCityDTO addCityDTO) {
        cityService.addCity(addCityDTO);
        return Result.success();
    }

}
