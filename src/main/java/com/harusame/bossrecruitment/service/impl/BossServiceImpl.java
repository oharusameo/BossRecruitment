package com.harusame.bossrecruitment.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.harusame.bossrecruitment.domain.pojo.Boss;
import com.harusame.bossrecruitment.service.BossService;
import com.harusame.bossrecruitment.mapper.BossMapper;
import org.springframework.stereotype.Service;

/**
* @author ggzst
* @description 针对表【t_boss(BOSS表)】的数据库操作Service实现
* @createDate 2023-11-04 19:45:17
*/
@Service
public class BossServiceImpl extends ServiceImpl<BossMapper, Boss>
    implements BossService{

}




