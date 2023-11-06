package com.harusame.bossrecruitment.api;

import com.harusame.bossrecruitment.common.annotation.RequireBoss;
import com.harusame.bossrecruitment.domain.dto.AddPositionDTO;
import com.harusame.bossrecruitment.domain.pojo.Result;
import com.harusame.bossrecruitment.service.PositionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@Api(tags = "职位接口", value = "PositionApi")
@RequestMapping("/api/v1/position")
@RestController
public class PositionApi {
    @Resource
    private PositionService positionService;

    @PostMapping("/addPosition")
    @RequireBoss
    @ApiOperation("发布职位")
    public Result addPosition(@ApiParam(name = "token", value = "身份认证令牌")
                              @RequestHeader String token, @RequestBody @Valid AddPositionDTO addPositionDTO) {
        positionService.addPosition(addPositionDTO);
        return Result.successMsg("发布职位成功");
    }


}
