package com.harusame.bossrecruitment.task;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MonitorTask {



//    @Scheduled(cron = "0 0 18 * * ?")//每天下班时间点触发
    public void clearSignStatInRedis() {
    }

//    @Scheduled(cron = "0 0 0 * * ?")//每天0点触发
    public void checkTrialTenantIfExpire() {


    }

}
