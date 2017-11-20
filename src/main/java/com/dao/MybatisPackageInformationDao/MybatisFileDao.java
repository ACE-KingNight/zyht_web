package com.dao.MybatisPackageInformationDao;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.dao.MybatisPackageInformationDao
 * @author wangzhenxin
 * @date 2017-10-25 9:17
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.domain.File;

/**
 * @author wangzhenxin
 * @InterfaceName MybatisFileDao
 * @Description 接口描述
 * @date 2017-10-25
 */
public interface MybatisFileDao {
    /**
     * @Title: getFile
     * @Description: 通过图片ID获取单个图片
     * @author wangzhenxin
     * @date 2017-10-25
     * @param id 图片ID
     * @return File 图片对象
     */

    public File getFile(Long id);

    public void insertFile(File file);

}
