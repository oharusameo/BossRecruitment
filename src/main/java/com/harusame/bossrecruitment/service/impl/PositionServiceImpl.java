package com.harusame.bossrecruitment.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.harusame.bossrecruitment.common.utils.TokenUtils;
import com.harusame.bossrecruitment.domain.dto.AddPositionDTO;
import com.harusame.bossrecruitment.domain.pojo.Boss;
import com.harusame.bossrecruitment.domain.pojo.Company;
import com.harusame.bossrecruitment.domain.pojo.Position;
import com.harusame.bossrecruitment.exception.BusinessException;
import com.harusame.bossrecruitment.mapper.BossMapper;
import com.harusame.bossrecruitment.mapper.CompanyMapper;
import com.harusame.bossrecruitment.service.PositionService;
import com.harusame.bossrecruitment.mapper.PositionMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ggzst
 * @description 针对表【t_position(职位表)】的数据库操作Service实现
 * @createDate 2023-11-04 19:45:17
 */
@Service
public class PositionServiceImpl extends ServiceImpl<PositionMapper, Position>
        implements PositionService {

    @Resource
    private TokenUtils tokenUtils;

    @Resource
    private BossMapper bossMapper;
    @Resource
    private CompanyMapper companyMapper;
    @Resource
    private PositionMapper positionMapper;

    @Override
    public void addPosition(AddPositionDTO addPositionDTO) {
        String bossIdFromHeader = tokenUtils.getBossIdFromHeader();
        Position position = new Position();
        BeanUtils.copyProperties(addPositionDTO, position);
        Boss boss = bossMapper.selectOne(new QueryWrapper<Boss>().eq("id", bossIdFromHeader).select("company_id"));
        if (boss == null) {
            throw new BusinessException("该公司不存在");
        }
        position.setBossId(Integer.parseInt(bossIdFromHeader));
        position.setCompanyId(boss.getCompanyId());
        positionMapper.insert(position);
    }


}




