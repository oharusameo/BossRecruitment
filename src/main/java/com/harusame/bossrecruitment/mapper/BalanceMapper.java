package com.harusame.bossrecruitment.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.harusame.bossrecruitment.domain.pojo.Balance;
import org.apache.ibatis.annotations.Update;

/**
 * @author ggzst
 * @description 针对表【t_balance(账户余额表)】的数据库操作Mapper
 * @createDate 2023-11-06 19:04:03
 * @Entity generator.bossrecruitment.Balance
 */
public interface BalanceMapper extends BaseMapper<Balance> {
    @Update("update t_balance set balance = balance + #{operation} where user_id = #{userId}")
    void updateBalance(String userId, Integer operation);
}




