package com.fileflow.model;

public class UploadRequest {
    private byte[] fileBytes;
    private String fileName;
    private String contentType;
    private String folder;

     public UploadRequest(byte[] fileBytes, String fileName, String contentType, String folder) {
        this.fileBytes = fileBytes;
        this.fileName = fileName;
        this.contentType = contentType;
        this.folder = folder;
    }

    public byte[] getFileBytes(){
        return fileBytes;
    }

    public String getFileName() {
        return fileName;
    }

    public String getContentType(){
        return contentType;
    }

    public String getFolder(){
        return folder;
    }




    
    
    
}
