package com.harusame.bossrecruitment.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.harusame.bossrecruitment.domain.pojo.Qualifications;
import com.harusame.bossrecruitment.service.QualificationsService;
import com.harusame.bossrecruitment.mapper.QualificationsMapper;
import org.springframework.stereotype.Service;

/**
* @author ggzst
* @description 针对表【t_qualifications(教育经历表)】的数据库操作Service实现
* @createDate 2023-11-04 19:45:17
*/
@Service
public class QualificationsServiceImpl extends ServiceImpl<QualificationsMapper, Qualifications>
    implements QualificationsService{

}




