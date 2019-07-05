package com.inca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inca.entity.pub.User;
import com.inca.mapper.UserMapper;

@Service
public class UserService {
	@Autowired
	UserMapper userMapper;
	public User getUserById(Integer id){
		User user = userMapper.selectUserById(id);
		return user;
	}

}
