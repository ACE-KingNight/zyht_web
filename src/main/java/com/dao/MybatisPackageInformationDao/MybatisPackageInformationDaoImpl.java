package com.dao.MybatisPackageInformationDao;/********************************************************************
/**
* @Project: zyht_mobile_package
* @Package com.dao.MyBatisDao
* @author wangzhenxin
* @date 2017-10-20 15:40
* @Copyright: 2017 www.zyht.com Inc. All rights reserved.
* @version V1.0
*/

import com.base.MyBatisBaseDaoImpl;
import com.domain.PackageInformation;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @author wangzhenxin
* @ClassName PackageInformationDaoImpl
* @Description 类描述
* @date 2017-10-20
*/
@Repository("mybatisPackageInformationDao")
public class MybatisPackageInformationDaoImpl extends MyBatisBaseDaoImpl<PackageInformation> implements MybatisPackageInformationDao {


    @Override
    public List<PackageInformation> getAllPackageInformation() {
        return sqlSessionTemplate.selectList(getMybaitsNameSpace()+"getAllPackageInformation");
    }

    @Override
    public PackageInformation getPackageInformation(PackageInformation packageInformation) {
        return sqlSessionTemplate.selectOne(getMybaitsNameSpace()+"getPackageInformation",packageInformation);
    }

    @Override
    public void insertPackageInformation(PackageInformation packageInformation) {
        sqlSessionTemplate.insert(getMybaitsNameSpace()+"insertPackageInformation", packageInformation);
    }

    @Override
    public void updatePackageInformation(PackageInformation packageInformation) {
        sqlSessionTemplate.update(getMybaitsNameSpace()+"updatePackageInformation", packageInformation);
    }

    @Override
    public void deletePackageInformation(PackageInformation packageInformation) {
        sqlSessionTemplate.delete(getMybaitsNameSpace()+"deletePackageInformation", packageInformation);
    }
}
