package com.harusame.bossrecruitment.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.harusame.bossrecruitment.domain.pojo.City;
import com.harusame.bossrecruitment.service.CityService;
import com.harusame.bossrecruitment.mapper.CityMapper;
import org.springframework.stereotype.Service;

/**
* @author ggzst
* @description 针对表【t_city(城市表)】的数据库操作Service实现
* @createDate 2023-11-04 19:45:17
*/
@Service
public class CityServiceImpl extends ServiceImpl<CityMapper, City>
    implements CityService{

}




