package cn.learn.mutil.datasource.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.learn.mutil.datasource.dao.master.CityDao;
import cn.learn.mutil.datasource.entity.City;

@Service
public class CityService {
	private static Logger logger = LoggerFactory.getLogger(CityService.class);

	@Autowired
	private CityDao dao;

    public City findById(Long id) {
    	logger.info("findByName is start");
    	City city = dao.findById(id);
    	logger.info("findByName is end");
        return city;
    }

}
