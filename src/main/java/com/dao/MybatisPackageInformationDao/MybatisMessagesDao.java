package com.dao.MybatisPackageInformationDao;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.dao.MybatisPackageInformationDao
 * @author wangzhenxin
 * @date 2017-10-25 19:44
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.domain.Messages;

import java.util.List;

/**
 * @author wangzhenxin
 * @InterfaceName MybatisMessagesDao
 * @Description 接口描述
 * @date 2017-10-25
 */
public interface MybatisMessagesDao {
    /**
     * @Title: getAllMessages
     * @Description: 通过客户ID获取当前客户的所有短信息信息
     * @author wangzhenxin
     * @date 2017-10-25
     * @param id 客户ID
     * @return List<Messages>
     */

    public List<Messages> getAllMessages(Long id);

    /**
     * @Title: insertMessages
     * @Description: 通过短信对象插入短信信息
     * @author wangzhenxin
     * @date 2017-10-25
     * @param messages 短信信息对象
     */

    public void insertMessages(Messages messages);
}
