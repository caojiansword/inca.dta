package com.inca.mapper;

import org.springframework.stereotype.Repository;

import com.inca.entity.pub.User;

@Repository
public interface UserMapper {
	User selectUserById(Integer id);
	Long countUser(User u);

}
