package com.service;/********************************************************************
 /**
 * @Project: JavaWorkSpaces
 * @Package mobile_package.service
 * @author wangzhenxin
 * @date 2017-08-20 12:28
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.base.BaseServiceImpl;
import com.dao.CallRecordsDao;
import com.dao.CallRecordsDaoImpl;
import com.dao.CustomerDao;
import com.dao.MybatisPackageInformationDao.MybatisCallRecordsDao;
import com.domain.CallRecords;
import com.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wangzhenxin
 * @ClassName CallRecordsServiceImpl
 * @Description 通话记录service
 * @date 2017-08-20
 */
@Service("callRecordsService")
@Transactional
public class CallRecordsServiceImpl extends BaseServiceImpl<Long,CallRecords,CallRecords> implements CallRecordsService{
//    //定义客户Dao对象
//    @Autowired
//    private CallRecordsDao callRecordsDao;

    //定义通话记录对象dao
    @Autowired
    private MybatisCallRecordsDao mybatisCallRecordsDao;

//    private CallRecordsDao callRecordsDao = new CallRecordsDaoImpl();

//    //构造方法
//    public CallRecordsServiceImpl(){
//        super.setBaseDao(callRecordsDao);
//    }
    /**
     * @Title:updateCallRecordsByCallRecords
     * @Description: 根据通话记录信息创建对应的通话记录
     * @author wangzhenxin
     * @date 2017-08-18
     * @param callRecords 通话记录信息
     * @return String
     */
    @Override
    public Long insertCallRecordsByCallRecords(CallRecords callRecords) {
        if (callRecords == null){
            return null;
        }
        return mybatisCallRecordsDao.insertCallRecords(callRecords);
    }

    @Override
    public List<CallRecords> findAllCallRecords(Long id) {
        return mybatisCallRecordsDao.getAllCallRecords(id);
//        return callRecordsDao.findAllCallRecords(id);
    }

    @Override
    public CallRecords findCallRecordsById(Long id) {
        return mybatisCallRecordsDao.getCallRecords(id);
    }

    @Override
    public String updateCallRecordsByCallRecords(CallRecords callRecords) {
//        update(callRecords);
        mybatisCallRecordsDao.updateCallRecords(callRecords);
        return "修改成功";
    }

}
