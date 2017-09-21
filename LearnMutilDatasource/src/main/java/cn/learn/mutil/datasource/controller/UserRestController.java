package cn.learn.mutil.datasource.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.learn.mutil.datasource.entity.City;
import cn.learn.mutil.datasource.entity.User;
import cn.learn.mutil.datasource.service.CityService;
import cn.learn.mutil.datasource.service.UserService;

/**
 * 用户控制层
 *
 * Created by bysocket on 07/02/2017.
 */
@RestController
public class UserRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private CityService cityService;

    /**
     * 根据用户名获取用户信息，包括从库的地址信息
     *
     * @param userName
     * @return
     */
    @RequestMapping(value = "/api/user", method = RequestMethod.GET)
    public User findByName(@RequestParam(value = "userName", required = true) String userName) {
    	User user= userService.findByName(userName);
    	City city= cityService.findById((long) 1);
    	user.setCity(city);
        return user;
    }

}
