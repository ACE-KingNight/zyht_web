package com.service;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.service
 * @author wangzhenxin
 * @date 2017-10-09 18:28
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.base.BaseServiceImpl;
import com.dao.FileDao;
import com.dao.FileDaoImpl;
import com.dao.MybatisPackageInformationDao.MybatisFileDao;
import com.domain.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author wangzhenxin
 * @ClassName FileServiceImpl
 * @Description 类描述
 * @date 2017-10-09
 */
@Service("fileService")
@Transactional
public class FileServiceImpl extends BaseServiceImpl<Long,File,File> implements FileService {
//    //定义客户Dao对象
//    @Autowired
//    private FileDao fileDao;
    @Autowired
    private MybatisFileDao mybatisFileDao;
//    //构造方法
//    public FileServiceImpl(){
//        super.setBaseDao(fileDao);
//    }
    @Override
    public void insertFile(File file) {
//        save(file);
        mybatisFileDao.insertFile(file);
    }

    @Override
    public File findFile(Long id) {
//        return fileDao.findFile(id);
        return mybatisFileDao.getFile(id);
    }
}
