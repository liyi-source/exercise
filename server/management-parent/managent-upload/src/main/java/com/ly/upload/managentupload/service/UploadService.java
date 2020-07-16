package com.ly.upload.managentupload.service;

import com.ly.upload.managentupload.entity.UploadEntity;
import com.ly.upload.managentupload.util.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class UploadService {
    @Autowired
    private UploadUtils uploadUtils;

    /**
     * @param uploadEntity
     * @author liyi
     * @data 2020/5/15
     */
    public void downloadFtpFile(UploadEntity uploadEntity){
//        uploadUtils.downloadFtpFile(uploadEntity.getFtpHost(),uploadEntity.getFtpPort(),uploadEntity.getFtpUserName(),uploadEntity.getFtpPassword());
    }
}
