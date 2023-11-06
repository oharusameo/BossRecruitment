package com.harusame.bossrecruitment.service;

import com.harusame.bossrecruitment.domain.dto.AddPositionDTO;
import com.harusame.bossrecruitment.domain.pojo.Position;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author ggzst
* @description 针对表【t_position(职位表)】的数据库操作Service
* @createDate 2023-11-04 19:45:17
*/
public interface PositionService extends IService<Position> {

    void addPosition(AddPositionDTO addPositionDTO);
}
