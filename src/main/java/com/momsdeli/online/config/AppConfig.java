package com.momsdeli.online.config;

import com.momsdeli.online.mapper.UserMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public UserMapper userMapper() {
        return new UserMapper();
    }
}
