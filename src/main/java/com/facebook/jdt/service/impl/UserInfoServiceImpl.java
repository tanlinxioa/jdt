package com.facebook.jdt.service.impl;

import com.facebook.jdt.mapper.UserInfoMapper;
import com.facebook.jdt.po.UserInfo;
import com.facebook.jdt.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserInfoServiceImpl implements IUserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> getUsers() {
        return userInfoMapper.findUserByUserInfo();
    }
}
