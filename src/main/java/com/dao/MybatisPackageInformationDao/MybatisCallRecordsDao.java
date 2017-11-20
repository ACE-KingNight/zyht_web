package com.dao.MybatisPackageInformationDao;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.dao.MybatisPackageInformationDao
 * @author wangzhenxin
 * @date 2017-10-24 16:45
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.domain.CallRecords;

import java.util.List;

/**
 * @author wangzhenxin
 * @InterfaceName MybatisCallRecordsDao
 * @Description 接口描述
 * @date 2017-10-24
 */
public interface MybatisCallRecordsDao {
    /**
     * @Title: getAllCallRecords
     * @Description: 通过客户id获取当前客户的所有通话记录信息
     * @author wangzhenxin
     * @date 2017-10-24
     * @param id 客户ID
     */

    public List<CallRecords> getAllCallRecords(Long id);

    /**
     * @Title: insertCallRecords
     * @Description: 根据通话记录信息插入通话记录
     * @author wangzhenxin
     * @date 2017-10-24
     * @param callRecords 通话记录对象
     */

    public Long insertCallRecords(CallRecords callRecords);

    /**
     * @Title: updateCallRecords
     * @Description: 根据通话记录对象修改对应的通话记录对象
     * @author wangzhenxin
     * @date 2017-10-24
     * @param callRecords 通话记录信息
     */

    public void updateCallRecords(CallRecords callRecords);

    /**
     * @Title: deleteCallRecords
     * @Description: 根据id删除对应的通话记录
     * @author wangzhenxin
     * @date 2017-10-24
     * @param id 通话记录ID
     */

    public void deleteCallRecords(Long id);

    /**
     * @Title: getCallRecords
     * @Description: 通过通话记录id查找对应的通话记录
     * @author wangzhenxin
     * @date 2017-10-24
     * @param id 通话记录ID
     * @return CallRecords
     */

    public CallRecords getCallRecords(Long id);
}
