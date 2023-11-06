package com.harusame.bossrecruitment.domain.vo;

import com.harusame.bossrecruitment.domain.pojo.Record;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@ApiModel("查询记录对象")
@Data
public class RecordVo {
    @ApiModelProperty
    private List<Record> recordList;
}
