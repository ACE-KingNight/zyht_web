package com.vo;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.vo
 * @author wangzhenxin
 * @date 2017-09-27 18:21
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.domain.Messages;

/**
 * @author wangzhenxin
 * @ClassName MessagesVo
 * @Description 类描述
 * @date 2017-09-27
 */
public class MessagesVo extends Messages {
    private String sendTime;
    private String receiveTime;

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(String receiveTime) {
        this.receiveTime = receiveTime;
    }
}
