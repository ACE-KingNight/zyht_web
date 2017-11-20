package com.service;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.service
 * @author wangzhenxin
 * @date 2017-09-20 17:55
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.base.BaseServiceImpl;
import com.dao.MybatisPackageInformationDao.MybatisPackageInformationDao;
import com.dao.PackageInformationDao;
import com.dao.PackageInformationDaoImpl;
import com.domain.PackageInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangzhenxin
 * @ClassName PackageInformationServiceImpl
 * @Description 套餐信息实现
 * @date 2017-09-20
 */
@Service("packageInformationService")
@Transactional
public class PackageInformationServiceImpl extends BaseServiceImpl<Long,PackageInformation,PackageInformation> implements PackageInformationService{
    //定义客户Dao对象
//    @Autowired
//    private PackageInformationDao packageInformationDao;

    //定义套餐对象DAO
    @Autowired
    private MybatisPackageInformationDao mybatisPackageInformationDao;

//    //构造方法
//    public PackageInformationServiceImpl(){
//        super.setBaseDao(packageInformationDao);
//    }
    @Override
    public String savePackageInformation(PackageInformation packageInformation) {
//        save(packageInformation);
        mybatisPackageInformationDao.insertPackageInformation(packageInformation);
        return "添加成功";
    }

    @Override
    public String deletePackageInformation(PackageInformation packageInformation) {
//        deleteById(packageInformation);
        mybatisPackageInformationDao.deletePackageInformation(packageInformation);
        return "删除成功";
    }

    @Override
    public String updatePackageInformation(PackageInformation packageInformation) {
//        update(packageInformation);
        mybatisPackageInformationDao.updatePackageInformation(packageInformation);
        return "修改成功";
    }

    @Override
    public PackageInformation findPackageInformation(PackageInformation packageInformation) {

        return mybatisPackageInformationDao.getPackageInformation(packageInformation);
    }

    @Override
    public List<PackageInformation> findAllPackageInformation() {
        List<PackageInformation> packageInformationList = new ArrayList<PackageInformation>();
        PackageInformation packageInformation = null;
//        packageInformationList = packageInformationDao.findAllPackageInformation();
        packageInformationList = mybatisPackageInformationDao.getAllPackageInformation();
        return packageInformationList;
    }
}
