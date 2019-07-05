package com.inca.service;


import com.alibaba.fastjson.JSONArray;

public interface LoginService {
    //查询登录是否正确
	int selectByExample(String username, String password);
	
}
