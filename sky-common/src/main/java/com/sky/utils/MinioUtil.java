package com.sky.utils;

import io.minio.MinioClient;

import io.minio.PutObjectArgs;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayInputStream;

@Data
@AllArgsConstructor
@Slf4j
public class MinioUtil {

    private String endpoint;
    private String accessKey;
    private String secretKey;
    private String bucketName;

    /**
     * 文件上传
     *
     * @param bytes      文件字节数组
     * @param objectName 文件名/相对路径
     * @return 文件访问路径
     */
    public String upload(byte[] bytes, String objectName) {
        try {
            // 1. 创建 MinioClient 实例
            MinioClient minioClient = MinioClient.builder()
                    .endpoint(endpoint)
                    .credentials(accessKey, secretKey)
                    .build();

            // 2. 上传文件到指定 Bucket
            ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
            minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(bucketName)
                            .object(objectName)
                            .stream(inputStream, bytes.length, -1)
                            .build()
            );

            // 3. 拼接访问 URL（格式如：http://192.168.76.129:9000/bucketName/objectName）
            String url = endpoint + "/" + bucketName + "/" + objectName;
            log.info("文件上传成功，访问路径: {}", url);

            return url;
        } catch (Exception e) {
            log.error("MinIO 文件上传失败", e);
            throw new RuntimeException("文件上传失败", e);
        }
    }
}