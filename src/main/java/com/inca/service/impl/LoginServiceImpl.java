package com.inca.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inca.entity.pub.User;
import com.inca.mapper.UserMapper;
import com.inca.service.LoginService;

@Service
@Transactional  //spring boot中的事物管理 不仅可以作用在类上，还可以作用在方法上
public class LoginServiceImpl implements LoginService {
      
	@Autowired
	private  UserMapper usermapper;
	
	@Override
	public int selectByUserNameAndPassword(String username, String password) {
		  User u = new User();
		  u.setUserName(username);
		  u.setPassword(password);
		  Long count=(Long) usermapper.countUser(u);
		   if (count==1) {
			   return 1;
		     }else{
		    	 return 0;
		     }
	}
	
}




