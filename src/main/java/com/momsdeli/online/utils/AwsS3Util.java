package com.momsdeli.online.utils;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class AwsS3Util {

    private static final Logger logger = LoggerFactory.getLogger(AwsS3Util.class);
    private final AmazonS3 amazonS3;
    private final String bucketName = "your-s3-bucket-name";

    public String uploadFile(MultipartFile file) {
        String fileName = file.getOriginalFilename();

        try {
            amazonS3.putObject(new PutObjectRequest(bucketName, fileName, file.getInputStream(), null)
                    .withCannedAcl(CannedAccessControlList.PublicRead));
        } catch (IOException e) {
            logger.error("Failed to upload file to S3", e);
            throw new RuntimeException("Failed to upload file to S3", e);
        }

        return amazonS3.getUrl(bucketName, fileName).toString();
    }
}
