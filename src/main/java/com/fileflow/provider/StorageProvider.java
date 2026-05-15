package com.fileflow.provider;

import com.fileflow.model.SignedUrlResult;
import com.fileflow.model.UploadRequest;
import com.fileflow.model.UploadResult;

public interface StorageProvider {

    UploadResult upload(UploadRequest uploadRequest);

    SignedUrlResult generateSignedUrl(String fileName, long expirySeconds);

}