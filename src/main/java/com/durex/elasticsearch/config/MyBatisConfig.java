package com.durex.elasticsearch.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author gelong
 */
@Configuration
@MapperScan({"com.durex.elasticsearch.dao"})
public class MyBatisConfig {
}
