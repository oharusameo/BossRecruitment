package com.harusame.bossrecruitment.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.harusame.bossrecruitment.common.constant.BalanceOperation;
import com.harusame.bossrecruitment.common.enums.PayEnum;
import com.harusame.bossrecruitment.common.utils.TokenUtils;
import com.harusame.bossrecruitment.domain.dto.RechargeDTO;
import com.harusame.bossrecruitment.domain.pojo.Balance;
import com.harusame.bossrecruitment.domain.vo.BalanceVo;
import com.harusame.bossrecruitment.exception.BusinessException;
import com.harusame.bossrecruitment.exception.SystemException;
import com.harusame.bossrecruitment.mapper.BalanceMapper;
import com.harusame.bossrecruitment.service.BalanceService;
import com.harusame.bossrecruitment.service.RecordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;


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
        String userId = tokenUtils.getUserIdFromHeader();
        Balance balance = new Balance();
        balance.setUserId(Integer.parseInt(userId));
        balance.setBalance(rechargeDTO.getMoney());
        balanceMapper.insert(balance);
        recordService.addRecord(userId, BalanceOperation.RECHARGE, rechargeDTO.getMoney());
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

    @Override
    public void checkBalance(String userId, PayEnum payEnum) {
        Balance balance = balanceMapper.selectOne(new QueryWrapper<Balance>().eq("user_id", userId).select("balance"));
        if (balance.getBalance().compareTo(new BigDecimal(payEnum.getValue())) <= 0) {
            throw new BusinessException("余额不足，购买失败");
        }
    }

    @Override
    public void pay(String userId, PayEnum payEnum) {
        int operation = 0;
        switch (payEnum) {
            case PAY_FOR_POSITION: {
                operation = -10;
                break;
            }
        }
        balanceMapper.updateBalance(userId, operation);
        String purchaseOperation = String.format(BalanceOperation.PURCHASE, payEnum.getDesc());
        recordService.addRecord(userId, purchaseOperation, new BigDecimal(payEnum.getValue()).negate());
    }
}




