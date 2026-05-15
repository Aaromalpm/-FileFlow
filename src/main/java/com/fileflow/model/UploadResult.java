package com.fileflow.model;

public class UploadResult {
    private String fileUrl;
    private String fileName;
    private long fileSize;
    private String storageType;

    public UploadResult(String fileUrl, String fileName, long fileSize, String storageType) {
        this.fileUrl = fileUrl;
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.storageType = storageType;
    }

    public String getFileUrl(){
        return fileUrl;
    }

    public String getFileName(){
        return fileName;
    }

    public long getFileSize(){
        return fileSize;
    }

    public String getStorageType(){
        return storageType;
    }

}
