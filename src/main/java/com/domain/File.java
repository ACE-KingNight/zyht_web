package com.domain;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.domain
 * @author wangzhenxin
 * @date 2017-10-09 18:15
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.base.IdEntity;

/**
 * @author wangzhenxin
 * @ClassName File
 * @Description 类描述
 * @date 2017-10-09
 */
public class File extends IdEntity<Long> {
    /**
     * 文件名
     */
    String fileName;
    /**
     * 文件大小
     */
    String fileLength;
    /**
     * 文件类型
     */
    String fileType;
    /**
     * 文件路径
     */
    String filePath;

    /**
     * 套餐对象ID
     */
    Long packageInformationId;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileLength() {
        return fileLength;
    }

    public void setFileLength(String fileLength) {
        this.fileLength = fileLength;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Long getPackageInformationId() {
        return packageInformationId;
    }

    public void setPackageInformationId(Long packageInformationId) {
        this.packageInformationId = packageInformationId;
    }
}
