package com.harusame.bossrecruitment.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.harusame.bossrecruitment.domain.pojo.Record;
import com.harusame.bossrecruitment.domain.vo.RecordVo;

import java.math.BigDecimal;

/**
* @author ggzst
* @description 针对表【t_record(余额变动记录表)】的数据库操作Service
* @createDate 2023-11-06 19:03:23
*/
public interface RecordService extends IService<Record> {

    void addRecord(String userId, String operation, BigDecimal money);

    RecordVo viewRecords();
}
