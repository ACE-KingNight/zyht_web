package com.dao;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.dao
 * @author wangzhenxin
 * @date 2017-09-26 19:29
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.base.BaseDaoImpl;
import com.common.DataSourceUtils;
import com.common.JdbcUtils;
import com.domain.Customer;
import com.domain.Messages;
import com.service.CustomerService;
import com.service.CustomerServiceImpl;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangzhenxin
 * @ClassName MessagesDaoImpl
 * @Description MessagesDao实现
 * @date 2017-09-26
 */
@Repository("messagesDao")
public class MessagesDaoImpl  extends BaseDaoImpl<Long, Messages> implements MessagesDao{
    //定义连接对象
    private Connection conn = null;
    //定义预编译对象
    private PreparedStatement pstmt = null;
    //定义结果集
    ResultSet rs = null;
    //创建自定义连接池对象
    private DataSource dataSource = new DataSourceUtils();


    @Resource
    private CustomerService customerService;


//    private CustomerService customerService =new CustomerServiceImpl();

    @Override
    public String saveMessage(Messages messages) {
        addEntity(messages);
        return "添加成功";
    }

    @Override
    public List<Messages> findAllMessage(Long id) {
        List<Messages> messagesList = new ArrayList<Messages>();
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            pstmt = conn.prepareStatement("SELECT SEND_CUSTOMER_ID,RECEIVE_CUSTOMER_ID,CONSUMPTION,SEND_MESSAGES_TIME,RECEIVE_MESSAGES_TIME,MESSAGES_TYPE,IS_RECEIVE,MESSAGE_CONTENT,CUSTOMER_TYPE\n" +
                    "FROM MESSAGES WHERE SEND_CUSTOMER_ID = ? AND CUSTOMER_TYPE = 1  OR RECEIVE_CUSTOMER_ID = ? AND CUSTOMER_TYPE = 2;");
            pstmt.setLong(1, id);
            pstmt.setLong(2, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Messages messages = new Messages();
                Customer sendCustomer = new Customer();
                Customer receiveCustomer = new Customer();
                sendCustomer.setId(rs.getLong("SEND_CUSTOMER_ID"));
                customerService.selectCustomer(sendCustomer);
                receiveCustomer.setId(rs.getLong("RECEIVE_CUSTOMER_ID"));
                customerService.selectCustomer(receiveCustomer);
                messages.setSendCustomer(sendCustomer);
                messages.setReceiveCustomer(receiveCustomer);
                messages.setConsumption(rs.getDouble("CONSUMPTION"));
                messages.setIsReceive(rs.getBoolean("IS_RECEIVE"));
                messages.setMessageContent(rs.getString("MESSAGE_CONTENT"));
                messages.setMessagesType(rs.getByte("MESSAGES_TYPE"));
                messages.setCustomerType(rs.getByte("CUSTOMER_TYPE"));
                if(rs.getDate("SEND_MESSAGES_TIME") != null){
                    Timestamp timestamp = rs.getTimestamp("SEND_MESSAGES_TIME");
                    java.util.Date date  = new java.util.Date(timestamp.getTime());
                    messages.setSendMessagesTime(date);
                }else {
                    messages.setSendMessagesTime(null);
                }
                if(rs.getDate("RECEIVE_MESSAGES_TIME") != null){
                    Timestamp timestamp = rs.getTimestamp("RECEIVE_MESSAGES_TIME");
                    java.util.Date date  = new java.util.Date(timestamp.getTime());
                    messages.setReceiveMessagesTime(date);
                }else {
                    messages.setReceiveMessagesTime(null);
                }
                messagesList.add(messages);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.release(conn, pstmt, rs);
        }
        return messagesList;
    }
}
