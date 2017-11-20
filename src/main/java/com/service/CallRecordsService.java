package com.service;/********************************************************************
 /**
 * @Project: JavaWorkSpaces
 * @Package mobile_package.service
 * @author wangzhenxin
 * @date 2017-08-20 12:25
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.base.BaseService;
import com.domain.CallRecords;

import java.util.List;


/**
 * @author wangzhenxin
 * @InterfaceName CallRecordsService
 * @Description 通话记录service
 * @date 2017-08-20
 */
public interface CallRecordsService extends BaseService<Long,CallRecords,CallRecords> {
    /**
     * @Title:updateCallRecordsByCallRecords
     * @Description: 根据通话记录信息更新对应的通话记录
     * @author wangzhenxin
     * @date 2017-08-18
     * @param callRecords 通话记录信息
     * @return String
     */
    public Long insertCallRecordsByCallRecords(CallRecords callRecords);

    public List<CallRecords> findAllCallRecords(Long id);

    public CallRecords findCallRecordsById(Long id);

    public String updateCallRecordsByCallRecords(CallRecords callRecords);
}
