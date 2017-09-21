package cn.learn.mutil.datasource.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.learn.mutil.datasource.dao.cluster.UserDao;
import cn.learn.mutil.datasource.entity.User;

@Service
public class UserService {
	private static Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserDao userDao;

    public User findByName(String userName) {
    	logger.info("findByName is start");
        User user = userDao.findByName(userName);
    	logger.info("findByName is end");
        return user;
    }

}
