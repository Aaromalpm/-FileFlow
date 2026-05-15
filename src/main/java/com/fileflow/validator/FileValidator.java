package com.fileflow.validator;

import com.fileflow.model.UploadRequest;
import java.util.List;

public class FileValidator {
    public void validate(UploadRequest request, long maxSizeBytes, List<String> allowedExtensions) {
        if (request.getFileBytes().length > maxSizeBytes) {
            throw new IllegalArgumentException("File size exceeds maximum allowed size");
        }

        String fileName = request.getFileName();

        boolean isValidExtension = false;

        for (String allowedExtension : allowedExtensions) {

            if (fileName.substring(fileName.lastIndexOf(".")).contains(allowedExtension)){
                isValidExtension = true;
            }
        }

        if(!isValidExtension){
             throw new IllegalArgumentException("File type not allowed");
        }
    }

}
