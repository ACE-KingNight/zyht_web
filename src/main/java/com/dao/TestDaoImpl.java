package com.dao;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.dao
 * @author guohongjin
 * @date 2017/10/13 15:34
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */


import com.domain.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author guohongjin
 * @ClassName TestDaoImpl
 * @Description 类描述
 * @date 2017/10/13
 */

/**
 * 配置do接口的实现和bean的名称，注入名称跟配置名称一样的
 */
@Component("testDao")
public class TestDaoImpl implements TestDao {

    /**
     * 注入springjdbc的帮助bean
     */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void testdao() {
        System.out.println("输出testdao");
        List<Test> testList=this.jdbcTemplate.query("SELECT id,`NAME` FROM test WHERE id=2",new ResultSetExtractor<List<Test>>() {
            @Override
            public List<Test> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                List<Test> testList=new ArrayList<Test>();
                while (resultSet.next()){
                    Test test=new Test();
                    test.setId(resultSet.getLong("id"));
                    test.setName(resultSet.getString("NAME"));
                    testList.add(test);
                }
                return testList;
            }
        });
        System.out.println(testList.size());
    }

    @Override
    public void insert() {
        this.jdbcTemplate.update("UPDATE test SET `NAME`='teset' WHERE id=?",1);

    }
}
