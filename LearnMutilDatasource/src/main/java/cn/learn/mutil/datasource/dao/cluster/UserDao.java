package cn.learn.mutil.datasource.dao.cluster;


import org.springframework.data.repository.query.Param;

import cn.learn.mutil.datasource.entity.User;

/**
 * 城市 DAO 接口类
 *
 */
public interface UserDao {

    /**
     * 根据用户名获取用户信息
     *
     * @param userName
     * @return
     */
    User findByName(@Param("eid") String eid);
}
