package com.harusame.bossrecruitment.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.harusame.bossrecruitment.common.utils.TokenUtils;
import com.harusame.bossrecruitment.domain.dto.CreateSeekerDTO;
import com.harusame.bossrecruitment.domain.pojo.Qualifications;
import com.harusame.bossrecruitment.domain.pojo.Seeker;
import com.harusame.bossrecruitment.domain.pojo.User;
import com.harusame.bossrecruitment.mapper.QualificationsMapper;
import com.harusame.bossrecruitment.mapper.UserMapper;
import com.harusame.bossrecruitment.service.SeekerService;
import com.harusame.bossrecruitment.mapper.SeekerMapper;
import com.harusame.bossrecruitment.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author ggzst
 * @description 针对表【t_seeker(求职者表)】的数据库操作Service实现
 * @createDate 2023-11-04 19:45:17
 */
@Service
public class SeekerServiceImpl extends ServiceImpl<SeekerMapper, Seeker>
        implements SeekerService {

    @Resource
    private TokenUtils tokenUtils;
    @Resource
    private UserService userService;
    @Resource
    private SeekerMapper seekerMapper;
    @Resource
    private QualificationsMapper qualificationsMapper;

    @Override
    @Transactional
    public void createSeeker(CreateSeekerDTO createSeekerDTO) {
        String id = tokenUtils.getUserIdFromHeader();
        userService.updateUser(id, createSeekerDTO);
        insertSeeker(id, createSeekerDTO);
        insertQualifications(id, createSeekerDTO);
    }

    private void insertSeeker(String id, CreateSeekerDTO createSeekerDTO) {
        Seeker seeker = new Seeker();
        seeker.setUserId(Integer.valueOf(id));
        BeanUtils.copyProperties(createSeekerDTO, seeker);
        seekerMapper.insert(seeker);
    }

    private void insertQualifications(String id, CreateSeekerDTO createSeekerDTO) {
        Qualifications qualifications = new Qualifications();
        qualifications.setUserId(Integer.valueOf(id));
        BeanUtils.copyProperties(createSeekerDTO, qualifications);
        qualificationsMapper.insert(qualifications);
    }


}




