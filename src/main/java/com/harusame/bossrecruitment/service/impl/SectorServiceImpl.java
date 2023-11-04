package com.harusame.bossrecruitment.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.harusame.bossrecruitment.domain.pojo.Sector;
import com.harusame.bossrecruitment.service.SectorService;
import com.harusame.bossrecruitment.mapper.SectorMapper;
import org.springframework.stereotype.Service;

/**
* @author ggzst
* @description 针对表【t_sector(父行业表)】的数据库操作Service实现
* @createDate 2023-11-04 19:45:17
*/
@Service
public class SectorServiceImpl extends ServiceImpl<SectorMapper, Sector>
    implements SectorService{

}




