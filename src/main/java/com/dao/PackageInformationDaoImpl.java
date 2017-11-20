package com.dao;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.dao
 * @author wangzhenxin
 * @date 2017-09-20 18:12
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.base.BaseDaoImpl;
import com.common.DataSourceUtils;
import com.common.JdbcUtils;
import com.domain.PackageInformation;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangzhenxin
 * @ClassName PackageInformationDaoImpl
 * @Description PackageInformationDao实现
 * @date 2017-09-20
 */
@Repository("packageInformationDao")
public class PackageInformationDaoImpl extends BaseDaoImpl<Long,PackageInformation> implements PackageInformationDao {
    //定义连接对象
    private Connection conn = null;
    //定义预编译对象
    private PreparedStatement pstmt = null;
    //定义结果集
    ResultSet rs = null;
    //创建自定义连接池对象
    private DataSource dataSource = new DataSourceUtils();
    @Override
    public PackageInformation addPackageInformation(PackageInformation packageInformation) {
        addEntity(packageInformation);
        return null;
    }

    @Override
    public PackageInformation findPackageInformation(PackageInformation packageInformation) {
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            pstmt = conn.prepareStatement("SELECT ID,MEAL_NUMBER,MEAL_NAME,MEAL_DESCRIBE,MESSAGE_NUMBER,MINUTE_NUMBER,FLOW_NUMBER,IS_CALL,IS_COLOR_BACK,MONTHLY_RENT,UNIT,MEAL_START_DATE,MEAL_END_DATE FROM package_information WHERE ID = ?");
            pstmt.setLong(1,packageInformation.getId());
            rs = pstmt.executeQuery();
            while (rs.next()){
                packageInformation.setId(rs.getLong("ID"));
                packageInformation.setMealNumber(rs.getString("MEAL_NUMBER"));
                packageInformation.setMealName(rs.getString("MEAL_NAME"));
                packageInformation.setMealDescribe(rs.getString("MEAL_DESCRIBE"));
                packageInformation.setMessageNumber(rs.getInt("MESSAGE_NUMBER"));
                packageInformation.setMinuteNumber(rs.getInt("MINUTE_NUMBER"));
                packageInformation.setFlowNumber(rs.getDouble("FLOW_NUMBER"));
                packageInformation.setIsCall(rs.getBoolean("IS_CALL"));
                packageInformation.setIsColorBack(rs.getBoolean("IS_COLOR_BACK"));
                packageInformation.setMonthlyRent(rs.getDouble("MONTHLY_RENT"));
                packageInformation.setUnit(rs.getString("UNIT"));
                packageInformation.setMealStartDate(rs.getDate("MEAL_START_DATE"));
                packageInformation.setMealEndDate(rs.getDate("MEAL_END_DATE"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.release(conn, pstmt, rs);
        }
        return packageInformation;
    }

    @Override
    public List<PackageInformation> findAllPackageInformation() {
        List<PackageInformation> packageInformationList = new ArrayList<PackageInformation>();
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            pstmt = conn.prepareStatement("SELECT ID,MEAL_NUMBER,MEAL_NAME,MEAL_DESCRIBE,MESSAGE_NUMBER,MINUTE_NUMBER,FLOW_NUMBER,IS_CALL,IS_COLOR_BACK,MONTHLY_RENT,UNIT,MEAL_START_DATE,MEAL_END_DATE FROM PACKAGE_INFORMATION");
            rs = pstmt.executeQuery();
            while (rs.next()){
                PackageInformation packageInformation = new PackageInformation();
                packageInformation.setId(rs.getLong("ID"));
                packageInformation.setMealNumber(rs.getString("MEAL_NUMBER"));
                packageInformation.setMealName(rs.getString("MEAL_NAME"));
                packageInformation.setMealDescribe(rs.getString("MEAL_DESCRIBE"));
                packageInformation.setMessageNumber(rs.getInt("MESSAGE_NUMBER"));
                packageInformation.setMinuteNumber(rs.getInt("MINUTE_NUMBER"));
                packageInformation.setFlowNumber(rs.getDouble("FLOW_NUMBER"));
                packageInformation.setIsCall(rs.getBoolean("IS_CALL"));
                packageInformation.setIsColorBack(rs.getBoolean("IS_COLOR_BACK"));
                packageInformation.setMonthlyRent(rs.getDouble("MONTHLY_RENT"));
                packageInformation.setUnit(rs.getString("UNIT"));
                packageInformation.setMealStartDate(rs.getDate("MEAL_START_DATE"));
                packageInformation.setMealEndDate(rs.getDate("MEAL_END_DATE"));
                packageInformationList.add(packageInformation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.release(conn, pstmt, rs);
        }
        return packageInformationList;
    }
}
