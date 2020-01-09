package com.mall.server.controller;

import com.mall.server.model.Response;
import com.mall.server.model.User;
import com.mall.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/4.
 */
@RestController
public class Usermanage {
    @Autowired
    private UserRepository userRepository;
    /**
     * 注册
     *
     * @return
     */
    @RequestMapping(value = "/api/user/signup", method = RequestMethod.POST)
    public Response signup(@RequestParam String userid,@RequestParam String username,@RequestParam String pwd,@RequestParam String address) {
        User user = userRepository.findByUserid(userid);
        Response response=new Response();
        if (user != null) {
            response.setCode(201);
            response.setMsg("");
            response.setT(user);
        } else {
            user=new User();
            user.setUserid(userid);
            user.setUsername(username);
            user.setPassword(pwd);
            user.setAddress(address);
            userRepository.save(user);
            response.setCode(200);
            response.setMsg("");
            response.setT(user);
        }
        return response;
    }

    /**
     * 登录
     *
     * @return
     */
    @RequestMapping(value = "/api/user/login", method = RequestMethod.POST)
    public Response login(@RequestParam String userid,@RequestParam String pwd) {
        User user = userRepository.findByUseridAndPassword(userid,pwd);
        Response response=new Response();
        if (user != null) {
            response.setCode(200);
            response.setMsg("");
            response.setT(user);
        } else {
            response.setCode(200);
            response.setMsg("");
            response.setT(null);
        }
        return response;
    }

}
