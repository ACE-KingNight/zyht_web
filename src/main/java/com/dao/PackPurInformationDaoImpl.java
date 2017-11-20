package com.dao;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.dao
 * @author wangzhenxin
 * @date 2017-09-24 13:20
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.base.BaseDaoImpl;
import com.common.DataSourceUtils;
import com.common.JdbcUtils;
import com.domain.Customer;
import com.domain.PackPurInformation;
import com.domain.PackageInformation;
import com.service.CustomerService;
import com.service.CustomerServiceImpl;
import com.service.PackageInformationService;
import com.service.PackageInformationServiceImpl;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.*;
import java.util.*;
import java.util.Date;

/**
 * @author wangzhenxin
 * @ClassName PackPurInformationDaoImpl
 * @Description PackPurInformationDao实现
 * @date 2017-09-24
 */
@Repository("packPurInformationDao")
public class PackPurInformationDaoImpl extends BaseDaoImpl<Long,PackPurInformation> implements PackPurInformationDao {
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

    @Resource
    PackageInformationService packageInformationService;

    @Override
    public String savePackPurInformation(PackPurInformation packPurInformation) {
        if (addEntity(packPurInformation)!=null){
            return "添加成功!!";
        }else {
            return "添加失败!!";
        }
    }

    @Override
    public List<PackPurInformation> findPackPurInformation(Long customerId) {
        List<PackPurInformation> packPurInformationList = new ArrayList<PackPurInformation>();

        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            pstmt = conn.prepareStatement("SELECT ID,BUY_TIME,CUSTOMER_ID,PACKAGE_INFORMATION_ID,AMOUNT_OF_PAYMENT,IS_SUCCESS,EFFECT_TIME FROM PACK_PUR_INFORMATION WHERE CUSTOMER_ID = ? ORDER BY ID DESC");
            pstmt.setLong(1, customerId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                PackPurInformation packPurInformation = new PackPurInformation();
                Customer customer = new Customer();
                PackageInformation packageInformation = new PackageInformation();
                //设置购买记录ID
                packPurInformation.setId(rs.getLong("ID"));
                //设置购买时间
                packPurInformation.setBuyTime(rs.getDate("BUY_TIME"));
                //设置客户ID
                customer.setId(rs.getLong("CUSTOMER_ID"));
                //根据客户ID查询客户信息
                customer = customerService.selectCustomer(customer);
                //设置购买套餐客户
                packPurInformation.setCustomer(customer);
                //设置套餐ID
                packageInformation.setId(rs.getLong("PACKAGE_INFORMATION_ID"));
                //根据套餐信息查询套餐信息
                packageInformation = packageInformationService.findPackageInformation(packageInformation);
                //设置购买套餐信息
                packPurInformation.setPackageInformation(packageInformation);
                //设置购买金额
                packPurInformation.setAmountOfPayment(rs.getDouble("AMOUNT_OF_PAYMENT"));
                //设置是否支付成功
                packPurInformation.setIsSuccess(rs.getBoolean("IS_SUCCESS"));
                //设置启用时间
                if(rs.getDate("EFFECT_TIME") != null){
                    Timestamp timestamp = rs.getTimestamp("EFFECT_TIME");
                    java.util.Date date  = new java.util.Date(timestamp.getTime());
                    packPurInformation.setEffectTime(date);
                }else {
                    packPurInformation.setEffectTime(null);
                }
                packPurInformationList.add(packPurInformation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.release(conn, pstmt, rs);
        }
        return packPurInformationList;
    }
}
