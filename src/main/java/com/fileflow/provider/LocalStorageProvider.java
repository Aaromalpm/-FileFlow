package com.fileflow.provider;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.fileflow.model.SignedUrlResult;
import com.fileflow.model.UploadRequest;
import com.fileflow.model.UploadResult;

public class LocalStorageProvider implements StorageProvider {
    private final String uploadDir;

    public LocalStorageProvider(String uploadDir) {
        this.uploadDir = uploadDir;
    }

    @Override
    public UploadResult upload(UploadRequest uploadRequest) {
        try {
            Path folderPath = Paths.get(uploadDir, uploadRequest.getFolder());
            Files.createDirectories(folderPath);
            Path filePath = folderPath.resolve(uploadRequest.getFileName());
            Files.write(filePath, uploadRequest.getFileBytes());
            return new UploadResult(filePath.toString(),
                    uploadRequest.getFileName(), uploadRequest.getFileBytes().length, "local");
        } catch (IOException e) {
            throw new RuntimeException("Failed to save file: " + e.getMessage(), e);
        }

    }

    @Override
    public SignedUrlResult generateSignedUrl(String fileName, long expirySeconds) {
        throw new UnsupportedOperationException("Signed URLs are not supported for local storage");

    }

}
