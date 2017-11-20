package com.dao.MybatisPackageInformationDao;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.dao.MybatisPackageInformationDao
 * @author wangzhenxin
 * @date 2017-10-25 19:47
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.base.MyBatisBaseDaoImpl;
import com.domain.Messages;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wangzhenxin
 * @ClassName MybatisMessagesDaoImpl
 * @Description 类描述
 * @date 2017-10-25
 */
@Repository("mybatisMessagesDao")
public class MybatisMessagesDaoImpl extends MyBatisBaseDaoImpl<Messages> implements MybatisMessagesDao {
    @Override
    public List<Messages> getAllMessages(Long id) {
        return sqlSessionTemplate.selectList(getMybaitsNameSpace()+"getAllMessages", id);
    }

    @Override
    public void insertMessages(Messages messages) {
        sqlSessionTemplate.insert(getMybaitsNameSpace()+"insertMessages", messages);
    }
}
