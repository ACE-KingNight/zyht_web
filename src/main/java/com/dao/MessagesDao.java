package com.dao;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.dao
 * @author wangzhenxin
 * @date 2017-09-26 19:28
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.base.BaseDao;
import com.domain.Messages;

import java.util.List;

/**
 * @author wangzhenxin
 * @InterfaceName MessagesDao
 * @Description MessagesDao
 * @date 2017-09-26
 */
public interface MessagesDao extends BaseDao<Long,Messages>{
    /**
     * @Title: saveMessage
     * @Description: 根据短息对象存储短信
     * @author wangzhenxin
     * @date 2017-09-26
     */
    public String saveMessage(Messages messages);

    /**
     * Title: findAllMessage
     * @Description: 查找所有短信信息
     * @author wangzhenxin
     * @date 2017-09-27
     */

    public List<Messages> findAllMessage(Long id);
}
