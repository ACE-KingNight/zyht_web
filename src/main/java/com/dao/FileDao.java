package com.dao;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.dao
 * @author wangzhenxin
 * @date 2017-10-10 8:53
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.base.BaseDao;
import com.domain.File;

/**
 * @author wangzhenxin
 * @InterfaceName FileDao
 * @Description 接口描述
 * @date 2017-10-10
 */
public interface FileDao extends BaseDao<Long,File> {
    public void InsertFile(File file);

    public File findFile(Long id);
}
