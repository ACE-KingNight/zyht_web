package com.dao.MybatisPackageInformationDao;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.dao.MybatisPackageInformationDao
 * @author wangzhenxin
 * @date 2017-10-25 11:50
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.base.MyBatisBaseDaoImpl;
import com.domain.PackPurInformation;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wangzhenxin
 * @ClassName MybatisPackPurInformationDaoImpl
 * @Description 类描述
 * @date 2017-10-25
 */
@Repository("mybatisPackPurInformationDao")
public class MybatisPackPurInformationDaoImpl extends MyBatisBaseDaoImpl<PackPurInformation>
implements MybatisPackPurInformationDao{
    @Override
    public List<PackPurInformation> getAllPackPurInformation(Long id) {
        return sqlSessionTemplate.selectList(getMybaitsNameSpace()+"getAllPackPurInformation", id);
    }

    @Override
    public void insertPackPurInformation(PackPurInformation packPurInformation) {
        sqlSessionTemplate.insert(getMybaitsNameSpace()+"insertPackPurInformation",packPurInformation);
    }

    @Override
    public void deletePackPurInformation(Long id) {
        sqlSessionTemplate.delete(getMybaitsNameSpace()+"deletePackPurInformation", id);
    }
}
