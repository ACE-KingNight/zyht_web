package com.dao;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.dao
 * @author wangzhenxin
 * @date 2017-09-24 13:19
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.base.BaseDao;
import com.domain.PackPurInformation;

import java.util.List;

/**
 * @author wangzhenxin
 * @InterfaceName PackPurInformationDao
 * @Description PackPurInformationDao
 * @date 2017-09-24
 */
public interface PackPurInformationDao extends BaseDao<Long,PackPurInformation> {
    /**
     * @Title: savePackPurInformation
     * @Description: 根据购买信息对象添加购买信息
     * @author wangzhenxin
     * @date 2017-09-24
     */

    public String savePackPurInformation(PackPurInformation packPurInformation);
    /**
     * @Title: findPackPurInformation
     * @Description: 查询套餐信息
     * @author wangzhenxin
     * @date 2017-09-24
     * @param customerId 客户id
     * @return List<PackPurInformation>
     */

    public List<PackPurInformation> findPackPurInformation(Long customerId);
}
