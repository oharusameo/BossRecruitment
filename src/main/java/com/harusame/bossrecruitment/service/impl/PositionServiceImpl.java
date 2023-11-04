package com.harusame.bossrecruitment.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.harusame.bossrecruitment.domain.pojo.Position;
import com.harusame.bossrecruitment.service.PositionService;
import com.harusame.bossrecruitment.mapper.PositionMapper;
import org.springframework.stereotype.Service;

/**
* @author ggzst
* @description 针对表【t_position(职位表)】的数据库操作Service实现
* @createDate 2023-11-04 19:45:17
*/
@Service
public class PositionServiceImpl extends ServiceImpl<PositionMapper, Position>
    implements PositionService{

}




