package com.momsdeli.online.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for AWS S3.
 *
 * @author Shahbaz Khan
 * @date 21/08/2024
 */
@Configuration
public class AwsS3Config {

    @Bean
    public AmazonS3 amazonS3() {
        BasicAWSCredentials awsCreds = new BasicAWSCredentials("your-access-key", "your-secret-key");

        return AmazonS3ClientBuilder.standard()
                .withRegion(Regions.US_EAST_1)  // Use your preferred region
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                .build();
    }
}
