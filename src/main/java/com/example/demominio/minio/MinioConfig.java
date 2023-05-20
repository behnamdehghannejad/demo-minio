package com.example.demominio.minio;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MinioConfig {

    @Value("${minio.access.key}")
    String accessKey;
    @Value("${minio.access.secret}")
    String secretKey;
    @Value("${minio.url}")
    String minioUrl;

    @Bean
    public MinioClient generateMinioClient() {
        try {
            MinioClient client = MinioClient.builder().credentials(accessKey, secretKey).endpoint(minioUrl).build();
            return client;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
