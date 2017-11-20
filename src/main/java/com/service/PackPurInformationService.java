package com.service;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.service
 * @author wangzhenxin
 * @date 2017-09-24 12:54
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.base.BaseService;
import com.domain.PackPurInformation;
import com.vo.PackPurInformationVo;

import java.util.List;

/**
 * @author wangzhenxin
 * @InterfaceName PackPurInformationService
 * @Description 套餐信息对象Service
 * @date 2017-09-24
 */
public interface PackPurInformationService extends BaseService<Long,PackPurInformation,PackPurInformationVo> {
    /**
     * @Title: savePackPurInformation
     * @Description: 添加套餐购买信息
     * @author wangzhenxin
     * @date 2017-09-24
     * @param packPurInformation 套餐信息对象
     */

    public String savePackPurInformation(PackPurInformation packPurInformation);

    /**
     * @Title: deletePackPurInformation
     * @Description: 删除购买套餐信息
     * @author wangzhenxin
     * @date 2017-09-24
     */
    public String deletePackPurInformation(PackPurInformation packPurInformation);

    /**
     * @Title: findPackPurInformation
     * @Description: 查询套餐信息
     * @author wangzhenxin
     * @date 2017-09-24
     * @param customerId 客户id
     * @return List<PackPurInformation>
     */
    public List<PackPurInformationVo> findPackPurInformation(Long customerId);
}
