package com.cursojpa.cursojpa.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.cursojpa.cursojpa.service.exceptions.FileException;

@Service
public class S3Service {
    
    private Logger LOG = LoggerFactory.getLogger(S3Service.class);

    @Value("${s3.bucket}")
    private String bucket;

    @Autowired
    private AmazonS3 s3client;

    public URI uploadFile(MultipartFile multipartFile){
        try {
            String filename = multipartFile.getOriginalFilename();
            InputStream is = multipartFile.getInputStream();
            String contentType = multipartFile.getContentType();
            return uploadFile(is, filename,contentType);
        } catch (IOException e) {
            e.printStackTrace();
            throw new FileException("Erro de IO: "+e.getMessage());
        }
    }

    public URI uploadFile(InputStream is, String filename, String contentType){
        try{
            ObjectMetadata meta = new ObjectMetadata();
            meta.setContentType(contentType);
            s3client.putObject(bucket,filename, is,meta);
            return s3client.getUrl(bucket, filename).toURI();
        } catch (URISyntaxException e) {
            throw new FileException("Erro ao converter URL pra URI");   
        }
    }

}
