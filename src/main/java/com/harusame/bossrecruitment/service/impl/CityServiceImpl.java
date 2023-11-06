package com.harusame.bossrecruitment.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.harusame.bossrecruitment.domain.dto.AddCityDTO;
import com.harusame.bossrecruitment.domain.pojo.City;
import com.harusame.bossrecruitment.service.CityService;
import com.harusame.bossrecruitment.mapper.CityMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ggzst
 * @description 针对表【t_city(城市表)】的数据库操作Service实现
 * @createDate 2023-11-04 19:45:17
 */
@Service
public class CityServiceImpl extends ServiceImpl<CityMapper, City>
        implements CityService {

    @Resource
    private CityMapper cityMapper;


    @Override
    public void addCity(AddCityDTO addCityDTO) {
        cityMapper.insertCities(addCityDTO.getCities());
    }
}




