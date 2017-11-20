package com.dao.MybatisPackageInformationDao;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.dao.MybatisPackageInformationDao
 * @author wangzhenxin
 * @date 2017-10-25 9:26
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.base.MyBatisBaseDaoImpl;
import com.domain.File;
import org.springframework.stereotype.Repository;

/**
 * @author wangzhenxin
 * @ClassName MybatisFileDaoImpl
 * @Description 类描述
 * @date 2017-10-25
 */
@Repository("mybatisFileDao")
public class MybatisFileDaoImpl extends MyBatisBaseDaoImpl<File> implements MybatisFileDao {
    @Override
    public File getFile(Long id) {

        return sqlSessionTemplate.selectOne(getMybaitsNameSpace()+"getFile", id);
    }

    @Override
    public void insertFile(File file) {
        sqlSessionTemplate.insert(getMybaitsNameSpace()+"insertFile",file);
    }
}
