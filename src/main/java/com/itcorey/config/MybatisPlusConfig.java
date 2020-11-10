package com.itcorey.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * @Auther: corey
 * @Date: 2020/9/7 17:50
 * @Description:
 */
@Configuration
@MapperScan("com.itcorey.mapper")
public class MybatisPlusConfig {

}
