package com.inca.service.impl;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.inca.entity.pub.ex.UserExample;
import com.inca.mapper.UserMapper;
import com.inca.service.LoginService;

@Service
@Transactional  //spring boot中的事物管理 不仅可以作用在类上，还可以作用在方法上
public class LoginServiceImpl implements LoginService {
      
	@Autowired
	private  UserMapper usermapper;
	
	@Override
	public int selectByExample(String username, String password) {
		   UserExample example=new UserExample();
		   com.inca.entity.pub.ex.UserExample.Criteria criteria=example.createCriteria();
		   criteria.andUserNameEqualTo(username);
		   criteria.andPasswordEqualTo(password);  
		  Long count=(Long) usermapper.countUser(example);
		   if (count==1) {
			   return 1;
		     }else{
		    	 return 0;
		     }
	}
	
}




