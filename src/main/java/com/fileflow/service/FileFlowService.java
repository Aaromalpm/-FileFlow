package com.fileflow.service;

import org.springframework.stereotype.Service;

import com.fileflow.config.FileFlowProperties;
import com.fileflow.model.SignedUrlResult;
import com.fileflow.model.UploadRequest;
import com.fileflow.model.UploadResult;
import com.fileflow.provider.StorageProvider;
import com.fileflow.validator.FileValidator;

@Service
public class FileFlowService {
    private final StorageProvider storageProvider;
    private final FileValidator fileValidator;
    private final FileFlowProperties fileFlowProperties;

    public FileFlowService(StorageProvider storageProvider, FileValidator fileValidator,
            FileFlowProperties fileFlowProperties) {
        this.storageProvider = storageProvider;
        this.fileValidator = fileValidator;
        this.fileFlowProperties = fileFlowProperties;
    }

    public UploadResult upload(UploadRequest uploadRequest) {
        fileValidator.validate(uploadRequest, fileFlowProperties.getMaxFileSize(),
                fileFlowProperties.getAllowedExtensions());
        return storageProvider.upload(uploadRequest);
    }

    public SignedUrlResult generateSignedUrl(String fileName, long expirySeconds) {
        return storageProvider.generateSignedUrl(fileName, expirySeconds);
    }

}
