package com.momsdeli.online.service;

import com.momsdeli.online.exception.S3FileRetrievalException;
import com.momsdeli.online.exception.S3UploadException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;

import java.io.IOException;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class S3Service {

    private final S3Client s3Client;
    @Value("${cloud.aws.s3.bucket-name}")
    private String bucketName;

    public String uploadFile(MultipartFile file) {
        String key = generateFileName(file);

        try {
            s3Client.putObject(
                    PutObjectRequest.builder()
                            .bucket(bucketName)
                            .key(key)
                            .build(),
                    software.amazon.awssdk.core.sync.RequestBody.fromBytes(file.getBytes())
            );
            log.info("File uploaded successfully to S3 with key: {}", key);
        } catch (IOException e) {
            log.error("Failed to upload file to S3 due to an IO exception", e);
            throw new S3UploadException("Failed to upload file to S3 due to an IO exception", e);
        } catch (S3Exception e) {
            log.error("S3 service error occurred while uploading file", e);
            throw new S3UploadException("Failed to upload file to S3", e);
        } catch (Exception e) {
            log.error("Unexpected error occurred while uploading file to S3", e);
            throw new S3UploadException("Unexpected error occurred while uploading file to S3", e);
        }

        return getFileUrl(key);
    }

    public byte[] downloadFile(String key) {
        try {
            return s3Client.getObject(
                    GetObjectRequest.builder()
                            .bucket(bucketName)
                            .key(key)
                            .build(),
                    software.amazon.awssdk.core.sync.ResponseTransformer.toBytes()
            ).asByteArray();
        } catch (S3Exception e) {
            log.error("S3 service error occurred while retrieving file with key: {}", key, e);
            throw new S3FileRetrievalException("Failed to retrieve file from S3", e);
        } catch (Exception e) {
            log.error("Unexpected error occurred while retrieving file from S3 with key: {}", key, e);
            throw new S3FileRetrievalException("Unexpected error occurred while retrieving file from S3", e);
        }
    }

    private String generateFileName(MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        if (originalFilename == null || originalFilename.trim().isEmpty()) {
            // Provide a fallback filename if the original filename is null or empty
            originalFilename = "default-filename";
        } else {
            originalFilename = originalFilename.replaceAll(" ", "_");
        }
        return UUID.randomUUID() + "-" + originalFilename;
    }

    private String getFileUrl(String key) {
        return String.format("https://%s.s3.amazonaws.com/%s", bucketName, key);
    }
}
