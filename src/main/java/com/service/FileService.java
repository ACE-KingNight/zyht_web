package com.service;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.service
 * @author wangzhenxin
 * @date 2017-10-09 18:21
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.base.BaseService;
import com.domain.File;

/**
 * @author wangzhenxin
 * @InterfaceName FileService
 * @Description 接口描述
 * @date 2017-10-09
 */
public interface FileService extends BaseService<Long,File,File>{
    public void insertFile(File file);

    public File findFile(Long id);
}
