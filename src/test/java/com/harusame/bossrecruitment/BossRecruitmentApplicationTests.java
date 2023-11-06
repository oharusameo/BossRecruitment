package com.harusame.bossrecruitment;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class BossRecruitmentApplicationTests {

    @Test
    void contextLoads() {
        BigDecimal bigDecimal = new BigDecimal("1000");
        int r = bigDecimal.compareTo(new BigDecimal(0));
        System.out.println("r = " + r);
    }

}
