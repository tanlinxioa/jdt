package com.facebook.jdt.controller;

import com.facebook.jdt.po.UserInfo;
import com.facebook.jdt.service.IUserInfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/")
public class UserInfoController {

    @Resource
    private IUserInfoService iUserInfoService;

    @RequestMapping("/test")
    public String test(){
        return "hello,world!";
    }

    @RequestMapping("/get")
    public List<UserInfo> getUsers(){
        return iUserInfoService.getUsers();
    }

}
