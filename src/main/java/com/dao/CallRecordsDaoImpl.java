package com.dao;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.dao
 * @author wangzhenxin
 * @date 2017-09-26 17:19
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.base.BaseDaoImpl;
import com.common.DataSourceUtils;
import com.common.JdbcUtils;
import com.domain.CallRecords;
import com.domain.Customer;
import com.service.CustomerService;
import com.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

/**
 * @author wangzhenxin
 * @ClassName CallRecordsDaoImpl
 * @Description CallRecordsDao实现
 * @date 2017-09-26
 */
@Repository("callRecordsDao")
public class CallRecordsDaoImpl extends BaseDaoImpl<Long,CallRecords> implements CallRecordsDao {
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

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public String saveCallRecords(CallRecords callRecords) {
        addEntity(callRecords);
        return "插入成功!!";

    }

    @Override
    public List<CallRecords> findAllCallRecords(Long id) {
        List<CallRecords> callRecordsList = new ArrayList<CallRecords>();
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            pstmt = conn.prepareStatement("SELECT CALL_CUSTOMER_ID,ANSWER_CUSTOMER_ID,CALL_DURATION,CONSUMPTION,START_CALL_TIME,END_CALL_TIME,CALL_TYPE,IS_ANSWER,DIAL_TYPE\n" +
                    "FROM CALL_RECORDS WHERE CALL_CUSTOMER_ID = ? AND DIAL_TYPE = 1 OR ANSWER_CUSTOMER_ID = ? AND DIAL_TYPE = 2;");
            pstmt.setLong(1, id);
            pstmt.setLong(2, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                CallRecords records = new CallRecords();
                Customer callCustomer = new Customer();
                Customer answerCustomer = new Customer();
                callCustomer.setId(rs.getLong("CALL_CUSTOMER_ID"));
                answerCustomer.setId(rs.getLong("ANSWER_CUSTOMER_ID"));
                records.setCallCustomer(customerService.selectCustomer(callCustomer));
                records.setAnswerCustomer(customerService.selectCustomer(answerCustomer));
                records.setCallDuration(rs.getLong("CALL_DURATION"));
                records.setConsumption(rs.getDouble("CONSUMPTION"));
                if(rs.getDate("START_CALL_TIME") != null){
                    Timestamp timestamp = rs.getTimestamp("START_CALL_TIME");
                    java.util.Date date  = new java.util.Date(timestamp.getTime());
                    records.setStartCallTime(date);
                }else {
                    records.setStartCallTime(null);
                }
                if(rs.getDate("END_CALL_TIME") != null){
//                    java.sql.Date date= rs.getDate("END_CALL_TIME");
//                    java.util.Date d=new java.util.Date(date.getTime());
//                    TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
                    Timestamp timestamp = rs.getTimestamp("END_CALL_TIME");
                    java.util.Date date  = new java.util.Date(timestamp.getTime());
                    records.setEndCallTime(date);
                }else {
                    records.setEndCallTime(null);
                }
                records.setCallType(rs.getByte("CALL_TYPE"));
                records.setDialType(rs.getByte("DIAL_TYPE"));
                records.setIsAnswer(rs.getBoolean("IS_ANSWER"));
                callRecordsList.add(records);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.release(conn, pstmt, rs);
        }
        return callRecordsList;
    }

    @Override
    public CallRecords findCallRecordsById(Long id) {

        Connection connection = null;
        CallRecords callRecords = new CallRecords();
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            pstmt = connection.prepareStatement("SELECT ID,CALL_CUSTOMER_ID,ANSWER_CUSTOMER_ID,CALL_DURATION,CONSUMPTION,START_CALL_TIME,END_CALL_TIME,CALL_TYPE,IS_ANSWER,DIAL_TYPE\n" +
                    "FROM CALL_RECORDS WHERE ID = ?");
            pstmt.setLong(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Customer callCustomer = new Customer();
                Customer answerCustomer = new Customer();
                callCustomer.setId(rs.getLong("CALL_CUSTOMER_ID"));
                answerCustomer.setId(rs.getLong("ANSWER_CUSTOMER_ID"));
                callRecords.setCallCustomer(customerService.selectCustomer(callCustomer));
                callRecords.setAnswerCustomer(customerService.selectCustomer(answerCustomer));
                callRecords.setCallDuration(rs.getLong("CALL_DURATION"));
                callRecords.setConsumption(rs.getDouble("CONSUMPTION"));
                if(rs.getDate("START_CALL_TIME") != null){
                    Timestamp timestamp = rs.getTimestamp("START_CALL_TIME");
                    java.util.Date date  = new java.util.Date(timestamp.getTime());
                    callRecords.setStartCallTime(date);
                }else {
                    callRecords.setStartCallTime(null);
                }
                if(rs.getDate("END_CALL_TIME") != null){
//                    java.sql.Date date= rs.getDate("END_CALL_TIME");
//                    java.util.Date d=new java.util.Date(date.getTime());
//                    TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
                    Timestamp timestamp = rs.getTimestamp("END_CALL_TIME");
                    java.util.Date date  = new java.util.Date(timestamp.getTime());
                    callRecords.setEndCallTime(date);
                }else {
                    callRecords.setEndCallTime(null);
                }
                callRecords.setCallType(rs.getByte("CALL_TYPE"));
                callRecords.setDialType(rs.getByte("DIAL_TYPE"));
                callRecords.setIsAnswer(rs.getBoolean("IS_ANSWER"));
                callRecords.setId(rs.getLong("ID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.release(conn, pstmt, rs);
        }
        return callRecords;
    }

    @Override
    public String updateCallRecordsByCallRecords(CallRecords callRecords) {
        updateEntity(callRecords);
        return "修改成功";
    }
}
