package com.inca.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inca.entity.pub.User;
import com.inca.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	
	@RequestMapping("/getUserById")
	@ResponseBody
	public String getUserById(@RequestParam("id") Integer id){
		
		User user = this.userService.getUserById(id);
		return user.toString();
		
	}

}
