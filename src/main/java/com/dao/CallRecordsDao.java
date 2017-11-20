package com.dao;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.dao
 * @author wangzhenxin
 * @date 2017-09-26 17:18
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.base.BaseDao;
import com.domain.CallRecords;

import java.util.List;

/**
 * @author wangzhenxin
 * @InterfaceName CallRecordsDao
 * @Description CallRecordsDao
 * @date 2017-09-26
 */
public interface CallRecordsDao extends BaseDao<Long,CallRecords> {

    /**
     * @Title: saveCallRecords
     * @Description: 根据通话记录添加通话记录
     * @author wangzhenxin
     * @date 2017-09-26
     */
    public String saveCallRecords(CallRecords callRecords);

    /**
     * @Title: findAllCallRecords
     * @Description: 通过客户id查找所有通话记录
     * @author wangzhenxin
     * @date 2017-09-27
     */
    public List<CallRecords> findAllCallRecords(Long id);

    /**
     * @Title: findCallRecordsById
     * @Description: 通过通话记录Id查找对应的通话记录
     * @author wangzhenxin
     * @date 2017-09-29
     */
    public CallRecords findCallRecordsById(Long id);

    /**
     * @Title: updateCallRecordsByCallRecords
     * @Description: 根据通话记录对象跟新通话记录
     * @author wangzhenxin
     * @date 2017-09-29
     */

    public String updateCallRecordsByCallRecords(CallRecords callRecords);

}
