package com.dao;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.dao
 * @author wangzhenxin
 * @date 2017-10-10 8:55
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.base.BaseDaoImpl;
import com.common.DataSourceUtils;
import com.common.JdbcUtils;
import com.domain.File;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;

/**
 * @author wangzhenxin
 * @ClassName FileDaoImpl
 * @Description 类描述
 * @date 2017-10-10
 */
@Repository("fileDao")
public class FileDaoImpl extends BaseDaoImpl<Long,File> implements FileDao {
    //定义连接对象
    private Connection conn = null;
    //定义预编译对象
    private PreparedStatement pstmt = null;
    //定义结果集
    ResultSet rs = null;
    //创建自定义连接池对象
    private DataSource dataSource = new DataSourceUtils();

    @Override
    public void InsertFile(File file) {
        addEntity(file);
    }

    @Override
    public File findFile(Long id) {
        File file = new File();
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            pstmt = conn.prepareStatement("SELECT ID,FILE_NAME,FILE_LENGTH,FILE_TYPE,FILE_PATH FROM FILE WHERE ID = ?");
            pstmt.setLong(1,id);
            rs = pstmt.executeQuery();
            while (rs.next()){
                file.setId(rs.getLong("ID"));
                file.setFileName(rs.getString("FILE_NAME"));
                file.setFileLength(rs.getString("FILE_LENGTH"));
                file.setFileType(rs.getString("FILE_TYPE"));
                file.setFilePath(rs.getString("FILE_PATH"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.release(conn, pstmt, rs);
        }
        return file;
    }
}
