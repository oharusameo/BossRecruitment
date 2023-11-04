package com.harusame.bossrecruitment.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.harusame.bossrecruitment.mapper")
public class MyBatisConfig {
//    @Bean
//    public MybatisPlusInterceptor mybatisPlusInterceptor() {
//        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
//        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));//配置添加分页插件,(建议)需要加上数据库类型
//        return interceptor;
//    }
}
