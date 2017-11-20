package com.base; /**
 * @Project: java_practice
 * @Package dao.base
 * @author xiaoshijie
 * @date 2017/9/6 21:34
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.common.DataSourceUtils;
import com.common.GetStandardSqlUtils;
import com.common.JdbcUtils;

import javax.sql.DataSource;
import java.lang.reflect.*;
import java.sql.*;

/**
 * @author xiaoshijie
 * @ClassName BaseDaoImpl
 * @Description 公共数据库操作实现类
 * @date 2017/9/6
 */
public class BaseDaoImpl<T, K> implements BaseDao<T, K> {
    //定义连接对象
    private Connection conn = null;
    //定义预编译对象
    private PreparedStatement pstmt = null;
    //定义结果集
    ResultSet rs = null;
    //创建自定义连接池对象
    private DataSource dataSource = new DataSourceUtils();
    /**
     * 定义泛型类的class
     */
    private Class<T> tClass;
    private Class<K> kClass;

    public BaseDaoImpl(){
        this.tClass= (Class<T>) BaseDaoImplClass();
        this.kClass = (Class<K>) BaseDaoImplKClass();

    }

    /**
     * @Title: BaseDaoImplClass
     * @Description: 获取当前类的父类然后获取父类的泛型类型，返回第一个泛型类型的class
     * @author wangzhenxin
     * @date 2017-08-23
     * @return Class<?>
     */
    public Class<?> BaseDaoImplClass(){
        //获取当前类的直接父类
        Type type=getClass().getGenericSuperclass();
        //判断类型是否有泛型
        if (type instanceof ParameterizedType){
            //获取他的泛型类型的数组
            Type[] types=((ParameterizedType) type).getActualTypeArguments();
            //返回第一个泛型类型的class
            return (Class<?>) types[0];
        }else {
            return Object.class;
        }
    }
    public Class<?> BaseDaoImplKClass(){
        //获取当前类的直接父类
        Type type=this.getClass().getGenericSuperclass();
        //判断类型是否有泛型
        if (type instanceof ParameterizedType){
            //获取他的泛型类型的数组
            Type[] types=((ParameterizedType) type).getActualTypeArguments();
            //返回第二个泛型类型的class
            return (Class<?>) types[1];
        }else {
            return Object.class;
        }
    }
    /**
     * @Title: addEntity
     * @Description: 添加对象
     * @author xiaoshijie
     * @date 2017-08-23
     * @param entity 对象
     * @return T
     */
    @Override
    public T addEntity(K entity) {
        //创建result,并初始化为-1
        long result = -1l;
        Object obj = null;

        try {
            //从池子中获得连接
            conn = dataSource.getConnection();
            //调用XsjUtil工具类中的getInsertSql获得完整的插入语句
            String sql = GetStandardSqlUtils.getInsertSql(entity);
            //预编译
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //添加数据，并返回操作的行数
            result = pstmt.executeUpdate();
            if (result > 0){
                //获得插入数据的结果集
                rs = pstmt.getGeneratedKeys();
                if (rs.next()){
                    //获得插入数据的id
                    obj = rs.getObject(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            //调用JdbcUtils工具类中的release方法释放资源
            JdbcUtils.release(conn, pstmt, rs);
        }
        T t = null;
        try {
            //获得tClass中的构造函数
            Constructor[] constructors = tClass.getConstructors();
            //调用以字符串为参数的构造函数，并初始化对象
            t = (T)constructors[1].newInstance(obj.toString());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return t;
    }

    /**
     * @Title: updateEntity
     * @Description: 更新对象
     * @author xiaoshijie
     * @date 2017-08-23
     * @param entity 对象
     * @return T
     */
    @Override
    public T updateEntity(K entity) {
        //创建result,并初始化为-1
        long result = -1l;
        Object obj = null;

        try {
            //从池子中获得连接
            conn = dataSource.getConnection();
            //调用XsjUtil工具类中的getIdUpdateSql获得完整的更新语句
            String sql = GetStandardSqlUtils.getIdUpdateSql(entity);
            //预编译
            pstmt = conn.prepareStatement(sql);

            //更新内容，并返回操作的行数
            result = pstmt.executeUpdate();
            Method method = kClass.getMethod("getId");
            Object object = kClass.newInstance();
            obj = method.invoke(entity);
//            Method method = kClass.getMethod("getId");
//            Object object = kClass.newInstance();
//            //如果id为空
//            if (method.invoke(object) == null){
//                System.out.println("getIdUpdateSql:id为空");
//            }
//            obj = method.invoke(object);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } finally {
            //调用JdbcUtils工具类中的release方法释放资源
            JdbcUtils.release(conn, pstmt, rs);
        }

        T t = null;
        try {
            //获得tClass中的构造函数
            Constructor[] constructors = tClass.getConstructors();
            //调用以字符串为参数的构造函数，并初始化对象
            t = (T)constructors[1].newInstance(obj.toString());
//            Method me = tClass.getMethod("valueOf", tClass);
//            me.invoke(t, obj);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return t;
    }

    /**
     * @Title: deleteEntity
     * @Description: 删除对象
     * @author xiaoshijie
     * @date 2017-08-23
     * @param entity 对象
     * @return T
     */
    @Override
    public T deleteEntity(K entity) {
        //创建result,并初始化为-1
        long result = -1l;
        Object obj = null;
        try {
            //从池子中获得连接
            conn = dataSource.getConnection();
            //调用XsjUtil工具类中的getDeleteSql获得完整的删除语句
            String sql = GetStandardSqlUtils.getDeleteSql(entity);
            //预编译
            pstmt = conn.prepareStatement(sql);
            //更新内容，并返回操作的行数即ID
            result = pstmt.executeUpdate();
            Method method = kClass.getMethod("getId");
            Object object = kClass.newInstance();
            obj = method.invoke(entity);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } finally {
            //调用JdbcUtils工具类中的release方法释放资源
            JdbcUtils.release(conn, pstmt, rs);
        }

        T t = null;
        try {
            //获得tClass中的构造函数
            Constructor[] constructors = tClass.getConstructors();
            //调用以字符串为参数的构造函数，并初始化对象
            t = (T)constructors[1].newInstance(obj.toString());
//            Method method = tClass.getMethod("valueOf", tClass);
//            method.invoke(t, obj);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return t;
    }
    public static Object getter(Object obj, String attr) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = obj.getClass().getMethod("get"+initStr(attr));
        return method.invoke(obj);
    }
    public static String initStr(String old){
        String str = old.substring(0,1).toUpperCase()+old.substring(1);
        return str;
    }

}

