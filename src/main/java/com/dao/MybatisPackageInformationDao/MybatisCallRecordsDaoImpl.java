package com.dao.MybatisPackageInformationDao;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.dao.MybatisPackageInformationDao
 * @author wangzhenxin
 * @date 2017-10-24 16:45
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.base.MyBatisBaseDaoImpl;
import com.domain.CallRecords;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author wangzhenxin
 * @ClassName MybatisCallRecordsDaoImpl
 * @Description 类描述
 * @date 2017-10-24
 */
@Repository("mybatisCallRecordsDao")
public class MybatisCallRecordsDaoImpl extends MyBatisBaseDaoImpl<CallRecords> implements MybatisCallRecordsDao {
    @Override
    public List<CallRecords> getAllCallRecords(Long id) {
        return sqlSessionTemplate.selectList(getMybaitsNameSpace()+ "getAllCallRecords", id);
    }

    @Override
    public Long insertCallRecords(CallRecords callRecords) {
        sqlSessionTemplate.insert(getMybaitsNameSpace()+"insertCallRecords", callRecords);
        return callRecords.getId();
    }

    @Override
    public void updateCallRecords(CallRecords callRecords) {
        sqlSessionTemplate.update(getMybaitsNameSpace()+"updateCallRecords", callRecords);
    }

    @Override
    public void deleteCallRecords(Long id) {
        sqlSessionTemplate.delete(getMybaitsNameSpace()+"deleteCallRecords", id);
    }

    @Override
    public CallRecords getCallRecords(Long id) {
        return sqlSessionTemplate.selectOne(getMybaitsNameSpace()+"getCallRecords", id);
    }
}
