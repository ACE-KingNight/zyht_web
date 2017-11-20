package com.service;/********************************************************************
 /**
 * @Project: JavaWorkSpaces
 * @Package mobile_package.service
 * @author wangzhenxin
 * @date 2017-08-18 15:45
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.base.BaseService;
import com.domain.PackageInformation;

import java.util.List;

/**
 * @author wangzhenxin
 * @InterfaceName PackageInformationService
 * @Description 套餐信息service
 * @date 2017-08-18
 */
public interface PackageInformationService extends BaseService<Long,PackageInformation,PackageInformation> {
    /**
     * @Title:
     * @Description: 添加套餐信息返回对应套餐信息（套餐信息的id）
     * @author wangzhenxin
     * @date 2017-08-18
     * @param packageInformation 套餐信息
     * @return packageInformation
     */
    public String savePackageInformation(PackageInformation packageInformation);

    /**
     * @Title: deletePackageInformation
     * @Description: 删除套餐信息
     * @author wangzhenxin
     * @date 2017-09-20
     * @param packageInformation 套餐信息对象
     * @return String
     */

    public String deletePackageInformation(PackageInformation packageInformation);

    /**
     * @Title: updatePackageInformation
     * @Description: 修改套餐信息
     * @author wangzhenxin
     * @date 2017-09-20
     * @param packageInformation 套餐信息
     * @return packageInformation
     */
    public String updatePackageInformation(PackageInformation packageInformation);

    /**
     * @Title: findPackageInformation
     * @Description: 查询套餐信息对象
     * @author wangzhenxin
     * @date 2017-09-20
     * @param packageInformation 套餐信息对象
     * @return PackageInformation
     */
    public PackageInformation findPackageInformation(PackageInformation packageInformation);

    /**
     * @Title: findAllPackageInfprmation
     * @Description: 查询所有套餐信息
     * @author wangzhenxin
     * @date 2017-09-20
     */

    public List<PackageInformation> findAllPackageInformation();
}
