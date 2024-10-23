package com.momsdeli.online.config;

import jakarta.servlet.MultipartConfigElement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.util.unit.DataSize;

/**
 * @author Shahbaz Khan
 * @date 29/08/2024
 */

@Configuration
public class FileUploadConfig {


    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        // Set the maximum file size
        factory.setMaxFileSize(DataSize.ofMegabytes(10));  // 10MB
        // Set the maximum request size
        factory.setMaxRequestSize(DataSize.ofMegabytes(10));  // 10MB
        return factory.createMultipartConfig();
    }
}
