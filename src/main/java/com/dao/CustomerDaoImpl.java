package com.dao;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.dao
 * @author wangzhenxin
 * @date 2017-09-15 21:27
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.base.BaseDaoImpl;
import com.common.DataSourceUtils;
import com.common.GetStandardSqlUtils;
import com.common.JdbcUtils;
import com.domain.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangzhenxin
 * @ClassName CustomerDaoImpl
 * @Description CustomerDao实现
 * @date 2017-09-15
 */
@Repository("customerDao")
public class CustomerDaoImpl extends BaseDaoImpl<Long,Customer> implements CustomerDao {
    //定义连接对象
    private Connection conn = null;
    //定义预编译对象
    private PreparedStatement pstmt = null;
    //定义结果集
    ResultSet rs = null;
    //创建自定义连接池对象
    private DataSource dataSource = new DataSourceUtils();

    @Override
    public String saveCustomer(Customer customer) {
        addEntity(customer);
        return "添加成功";
    }

    @Override
    public Customer selectCustomer(Customer customer) {
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            pstmt = conn.prepareStatement("SELECT ID,NAME,PHONE_CODE,SEX,ID_CARD,ADDRESS,BALANCE,PACKAGE_INFOMATION_ID,IS_SHUTDOWN,IS_STOP_ARREARS,STAR_STATES FROM customer WHERE ID = ?");
            pstmt.setLong(1,customer.getId());
            rs = pstmt.executeQuery();
            while (rs.next()){
                customer.setId(rs.getLong("ID"));
                customer.setName(rs.getString("NAME"));
                customer.setPhoneCode(rs.getString("PHONE_CODE"));
                customer.setSex(rs.getString("SEX"));
                customer.setIdCard(rs.getString("ID_CARD"));
                customer.setAddress(rs.getString("ADDRESS"));
                customer.setBalance(rs.getDouble("BALANCE"));
//                customer.setPackageInformation(Jdbcwork.selectPackageInformationById(rs.getLong("PACKAGE_INFOMATION_ID")));
                customer.setIsShutdown(rs.getBoolean("IS_SHUTDOWN"));
                customer.setIsStopArrears(rs.getBoolean("IS_STOP_ARREARS"));
                customer.setStarStates(rs.getByte("STAR_STATES"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.release(conn, pstmt, rs);
        }
        return customer;
    }

    @Override
    public String updateCustomer(Customer customer) {
        updateEntity(customer);
        return "修改成功";
    }

    @Override
    public List<Customer> selectAllCustomer() {
        List<Customer> customerList = new ArrayList<Customer>();
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            pstmt = conn.prepareStatement("SELECT ID,NAME,PHONE_CODE,SEX,ID_CARD,ADDRESS,BALANCE,PACKAGE_INFOMATION_ID,IS_SHUTDOWN,IS_STOP_ARREARS,STAR_STATES FROM CUSTOMER");
            rs = pstmt.executeQuery();
            while (rs.next()){
                Customer customer = new Customer();
                customer.setId(rs.getLong("ID"));
                customer.setName(rs.getString("NAME"));
                customer.setPhoneCode(rs.getString("PHONE_CODE"));
                customer.setSex(rs.getString("SEX"));
                customer.setIdCard(rs.getString("ID_CARD"));
                customer.setAddress(rs.getString("ADDRESS"));
                customer.setBalance(rs.getDouble("BALANCE"));
//                customer.setPackageInformation(Jdbcwork.selectPackageInformationById(rs.getLong("PACKAGE_INFOMATION_ID")));
                customer.setIsShutdown(rs.getBoolean("IS_SHUTDOWN"));
                customer.setIsStopArrears(rs.getBoolean("IS_STOP_ARREARS"));
                customer.setStarStates(rs.getByte("STAR_STATES"));
                customerList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.release(conn, pstmt, rs);
        }
        return customerList;
    }
//        //受影响的行数
//        int lenght = 0;
//        //定义预编译对象
//        PreparedStatement statement = null;
//        //定义连接对象
//        Connection conn = null;
//        //定义连接池对象
//        DataSource dataSource = new DataSourceUtils();
//        try {
//            //从连接池里获取连接
//            conn = dataSource.getConnection();
//            //插入sql语句
//            statement = conn.prepareStatement(GetStandardSqlUtils.getInsertSql(customer));
//            //执行SQL语句并返回受影响的行数
//            lenght = statement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } finally {
//            JdbcUtils.release(conn, statement, null);
//        }
//        if (lenght > 0) {
//            return "插入数据成功!";
//        } else {
//            return "插入数据失败!!";
//        }
//    }
}
