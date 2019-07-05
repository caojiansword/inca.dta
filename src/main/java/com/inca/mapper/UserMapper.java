package com.inca.mapper;

import org.springframework.stereotype.Repository;

import com.inca.entity.pub.User;
import com.inca.entity.pub.ex.UserExample;

@Repository
public interface UserMapper {
	User selectUserById(Integer id);
	Integer countUser(UserExample ue);

}
