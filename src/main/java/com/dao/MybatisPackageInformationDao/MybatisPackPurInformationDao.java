package com.dao.MybatisPackageInformationDao;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.dao.MybatisPackageInformationDao
 * @author wangzhenxin
 * @date 2017-10-25 11:46
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.domain.PackPurInformation;

import java.util.List;

/**
 * @author wangzhenxin
 * @InterfaceName MybatisPackPurInformationDao
 * @Description 接口描述
 * @date 2017-10-25
 */
public interface MybatisPackPurInformationDao {

    /**
     * @Title: getAllPackPurInformation
     * @Description: 通过客户ID获取当前客户的所有套餐购买信息记录
     * @author wangzhenxin
     * @date 2017-10-25
     * @param  id 客户Id
     * @return List<PackPurInformation>
     */

    public List<PackPurInformation> getAllPackPurInformation(Long id);

    /**
     * @Title: insertPackPurInformation
     * @Description: 根据客户套餐购买信息对象插入客户套餐购买记录
     * @author wangzhenxin
     * @date 2017-10-25
     * @param packPurInformation 套餐购买信息对象
     */

    public void insertPackPurInformation(PackPurInformation packPurInformation);

    /**
     * @Title: deletePackPurInformation
     * @Description: 根据套餐信息id删除对应的套餐购买信息
     * @author wangzhenxin
     * @date 2017-10-25
     * @param id 客户套餐信息ID
     */

    public void deletePackPurInformation(Long id);


}
