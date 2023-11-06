package com.harusame.bossrecruitment.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.harusame.bossrecruitment.mapper.RecordMapper;
import com.harusame.bossrecruitment.service.RecordService;
import org.springframework.stereotype.Service;
import com.harusame.bossrecruitment.domain.pojo.Record;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author ggzst
 * @description 针对表【t_record(余额变动记录表)】的数据库操作Service实现
 * @createDate 2023-11-06 19:03:23
 */
@Service
public class RecordServiceImpl extends ServiceImpl<RecordMapper, Record>
        implements RecordService {
    @Resource
    private RecordMapper recordMapper;

    @Override
    public void addRecord(String id, String operation, BigDecimal money) {
        operation = String.format("%s%s元", operation, money);
        recordMapper.addRecord(id, operation);
    }
}




