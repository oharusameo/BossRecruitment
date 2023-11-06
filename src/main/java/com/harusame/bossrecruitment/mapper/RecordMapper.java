package com.harusame.bossrecruitment.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.harusame.bossrecruitment.domain.pojo.Record;

import java.math.BigDecimal;

/**
 * @author ggzst
 * @description 针对表【t_record(余额变动记录表)】的数据库操作Mapper
 * @createDate 2023-11-06 19:03:23
 * @Entity generator.bossrecruitment.Record
 */
public interface RecordMapper extends BaseMapper<Record> {

    void addRecord(String userId, String operation);
}




