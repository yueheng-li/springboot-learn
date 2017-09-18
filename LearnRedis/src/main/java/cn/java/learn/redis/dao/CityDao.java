package cn.java.learn.redis.dao;

import java.util.List;

import org.springframework.data.repository.query.Param;

import cn.java.learn.redis.entity.City;

/**
 * 城市 DAO 接口类
 *
 */
public interface CityDao {

    /**
     * 获取城市信息列表
     *
     * @return
     */
    List<City> findAllCity();

    /**
     * 根据城市 ID，获取城市信息
     *
     * @param id
     * @return
     */
    City findById(@Param("id") Long id);

    Long saveCity(City city);

    Long updateCity(City city);

    Long deleteCity(Long id);
}

