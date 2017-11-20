package com.dao.MybatisPackageInformationDao;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.dao.MybatisPackageInformationDao
 * @author wangzhenxin
 * @date 2017-10-24 15:39
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.domain.PackageInformation;

import java.util.List;

/**
 * @author wangzhenxin
 * @InterfaceName MybatisPackageInformationDao
 * @Description 接口描述
 * @date 2017-10-24
 */
public interface MybatisPackageInformationDao {
    public List<PackageInformation> getAllPackageInformation();

    public PackageInformation getPackageInformation(PackageInformation packageInformation);

    public void insertPackageInformation(PackageInformation packageInformation);

    public void updatePackageInformation(PackageInformation packageInformation);

    public void deletePackageInformation(PackageInformation packageInformation);

}
