package com.harusame.bossrecruitment.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.harusame.bossrecruitment.common.utils.TokenUtils;
import com.harusame.bossrecruitment.domain.vo.RecordVo;
import com.harusame.bossrecruitment.mapper.RecordMapper;
import com.harusame.bossrecruitment.service.RecordService;
import org.springframework.stereotype.Service;
import com.harusame.bossrecruitment.domain.pojo.Record;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

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
    @Resource
    private TokenUtils tokenUtils;

    @Override
    public void addRecord(String userId, String operation, BigDecimal money) {
        operation = String.format("%s%s元", operation, money);
        recordMapper.addRecord(userId, operation);
    }

    @Override
    public RecordVo viewRecords() {
        String userId = tokenUtils.getUserIdFromHeader();
        List<Record> records = recordMapper.selectList(new QueryWrapper<Record>().eq("user_id", userId));
        RecordVo recordVo = new RecordVo();
        recordVo.setRecordList(records);
        return recordVo;
    }
}




