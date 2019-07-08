package com.inca.service;

public interface LoginService {
    //查询登录是否正确
	int selectByUserNameAndPassword(String username, String password);
	
}
