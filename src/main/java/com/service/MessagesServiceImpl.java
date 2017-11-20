package com.service;/********************************************************************
 /**
 * @Project: JavaWorkSpaces
 * @Package mobile_package.service
 * @author wangzhenxin
 * @date 2017-08-20 12:15
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */


import com.base.BaseServiceImpl;
import com.dao.MessagesDao;
import com.dao.MessagesDaoImpl;
import com.dao.MybatisPackageInformationDao.MybatisMessagesDao;
import com.domain.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wangzhenxin
 * @ClassName MessagesServiceImpl
 * @Description 短信service实现
 * @date 2017-08-20
 */
@Service("messagesService")
@Transactional
public class MessagesServiceImpl extends BaseServiceImpl<Long,Messages,Messages> implements MessagesService{
    //定义客户Dao对象
//    @Autowired
//    private MessagesDao messagesDao;

    @Autowired
    private MybatisMessagesDao mybatisMessagesDao;
//    //构造方法
//    public MessagesServiceImpl(){
//        super.setBaseDao(messagesDao);
//    }
    /**
     * @Title:updateMessagesByMessagesList
     * @Description: 根据短信记录集合更新对应的短信记录
     * @author wangzhenxin
     * @date 2017-08-18
     * @param messagesList 短信记录集合
     * @return String
     */
    @Override
    public String updateMessagesByMessagesList(List<Messages> messagesList) {
        for (int i = 0; i <messagesList.size(); i++) {
            mybatisMessagesDao.insertMessages(messagesList.get(i));
        }
        return "插入成功";
    }

    @Override
    public String saveMessage(Messages messages) {
//        save(messages);
        mybatisMessagesDao.insertMessages(messages);
        return "添加成功";
    }

    @Override
    public List<Messages> findAllMessage(Long id) {
//        return messagesDao.findAllMessage(id);
        return mybatisMessagesDao.getAllMessages(id);
    }
}
