package com.harusame.bossrecruitment.service;

import com.harusame.bossrecruitment.domain.dto.CreateBossDTO;
import com.harusame.bossrecruitment.domain.dto.CreateCompanyDTO;
import com.harusame.bossrecruitment.domain.pojo.Boss;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author ggzst
* @description 针对表【t_boss(BOSS表)】的数据库操作Service
* @createDate 2023-11-04 19:45:17
*/
public interface BossService extends IService<Boss> {

    void createBoss(CreateBossDTO createBossDTO);

}
