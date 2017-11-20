package com.vo;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.vo
 * @author wangzhenxin
 * @date 2017-09-27 11:22
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.domain.CallRecords;

/**
 * @author wangzhenxin
 * @ClassName CallRecordsVo
 * @Description 类描述
 * @date 2017-09-27
 */
public class CallRecordsVo extends CallRecords {
    private String startTime;
    private String endTime;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
