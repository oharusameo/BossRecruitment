package com.harusame.bossrecruitment.mapper;

import com.harusame.bossrecruitment.domain.pojo.City;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author ggzst
* @description 针对表【t_city(城市表)】的数据库操作Mapper
* @createDate 2023-11-04 19:45:17
* @Entity generator.bossrecruitment.City
*/
public interface CityMapper extends BaseMapper<City> {

    void insertCities(List<String> cities);
}




