package com.harusame.bossrecruitment.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.harusame.bossrecruitment.common.constant.BalanceOperation;
import com.harusame.bossrecruitment.common.utils.TokenUtils;
import com.harusame.bossrecruitment.domain.dto.RechargeDTO;
import com.harusame.bossrecruitment.domain.pojo.Balance;
import com.harusame.bossrecruitment.domain.vo.BalanceVo;
import com.harusame.bossrecruitment.exception.BusinessException;
import com.harusame.bossrecruitment.mapper.BalanceMapper;
import com.harusame.bossrecruitment.service.BalanceService;
import com.harusame.bossrecruitment.service.RecordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author ggzst
 * @description 针对表【t_balance(账户余额表)】的数据库操作Service实现
 * @createDate 2023-11-06 19:04:03
 */
@Service
public class BalanceServiceImpl extends ServiceImpl<BalanceMapper, Balance>
        implements BalanceService {

    @Resource
    private BalanceMapper balanceMapper;
    @Resource
    private RecordService recordService;
    @Resource
    private TokenUtils tokenUtils;

    @Override
    @Transactional
    public void recharge(RechargeDTO rechargeDTO) {
        String id = tokenUtils.getUserIdFromHeader();
        Balance balance = new Balance();
        balance.setUserId(Integer.parseInt(id));
        balance.setBalance(rechargeDTO.getMoney());
        balanceMapper.insert(balance);
        recordService.addRecord(id, BalanceOperation.RECHARGE, rechargeDTO.getMoney());
    }

    @Override
    public BalanceVo viewBalance() {
        Balance balance = balanceMapper.selectOne(new QueryWrapper<>());
        if (balance != null) {
            BalanceVo balanceVo = new BalanceVo();
            balanceVo.setBalance(balance.getBalance());
            balanceVo.setUserId(balance.getUserId());
            return balanceVo;
        }
        throw new BusinessException("暂未查询到对应用户的充值记录");
    }
}




