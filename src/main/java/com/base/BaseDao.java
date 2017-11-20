package com.base; /**
 * @Project: java_practice
 * @Package dao.base
 * @author xiaoshijie
 * @date 2017/9/6 21:33
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

/**
 * @author xiaoshijie
 * @InterfaceName BaseDao
 * @Description 公共数据库操作接口类
 * @date 2017/9/6
 */
public interface BaseDao<T,K> {
    /**
     * @Title: addEntity
     * @Description: 添加对象
     * @author xiaoshijie
     * @date 2017-08-23
     * @param entity 对象
     * @return T
     */
    public T addEntity(K entity);

    /**
     * @Title: updateEntity
     * @Description: 更新对象
     * @author xiaoshijie
     * @date 2017-08-23
     * @param entity 对象
     * @return T
     */
    public T updateEntity(K entity);

    /**
     * @Title: deleteEntity
     * @Description: 删除对象
     * @author xiaoshijie
     * @date 2017-08-23
     * @param entity 对象
     * @return T
     */
    public T deleteEntity(K entity);
}
