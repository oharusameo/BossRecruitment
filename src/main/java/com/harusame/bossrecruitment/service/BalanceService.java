package com.harusame.bossrecruitment.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.harusame.bossrecruitment.common.enums.PayEnum;
import com.harusame.bossrecruitment.domain.dto.RechargeDTO;
import com.harusame.bossrecruitment.domain.pojo.Balance;
import com.harusame.bossrecruitment.domain.vo.BalanceVo;

/**
 * @author ggzst
 * @description 针对表【t_balance(账户余额表)】的数据库操作Service
 * @createDate 2023-11-06 19:04:03
 */
public interface BalanceService extends IService<Balance> {

    void recharge(RechargeDTO rechargeDTO);

    BalanceVo viewBalance();

    void checkBalance(String userId, PayEnum payEnum);

    void pay(String userId, PayEnum payEnum);
}
