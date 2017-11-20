package com.dao;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.dao
 * @author wangzhenxin
 * @date 2017-09-20 18:10
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.base.BaseDao;
import com.domain.PackageInformation;

import java.util.List;

/**
 * @author wangzhenxin
 * @InterfaceName PackageInformationDao
 * @Description PackageInformationDao
 * @date 2017-09-20
 */
public interface PackageInformationDao extends BaseDao<Long,PackageInformation>{
    /**
     * @Title: addPackageInformation
     * @Description: 添加套餐信息
     * @author wangzhenxin
     * @date 2017-09-21
     */
    public PackageInformation addPackageInformation(PackageInformation packageInformation);
    /**
     * @Title: findPackageInformation
     * @Description: 查找套餐对象
     * @author wangzhenxin
     * @date 2017-09-20
     */

    public PackageInformation findPackageInformation(PackageInformation packageInformation);

    /**
     * @Title: findAllPackageInformation
     * @Description: 查询所有的套餐信息
     * @author wangzhenxin
     * @date 2017-09-20
     */

    public List<PackageInformation> findAllPackageInformation();
}
