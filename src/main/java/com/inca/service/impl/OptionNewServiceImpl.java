package com.inca.service.impl;



import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inca.entity.pub.User;
import com.inca.mapper.UserMapper;
import com.inca.service.LoginService;
import com.inca.service.OptionNewService;
import com.inca.utils.OptionMap;

@Service
@Transactional  
public class OptionNewServiceImpl implements OptionNewService {

	@Override
	public String getOptionValues(String key) throws Exception {
		// TODO Auto-generated method stub
		if(StringUtils.isEmpty(key)){
			return "";
		}
		String json=null;
		Properties properties = new Properties();
	    // 使用ClassLoader加载properties配置文件生成对应的输入流
	    InputStream in = OptionMap.class.getClassLoader().getResourceAsStream("option.properties");
	    // 使用properties对象加载输入流
	    try {
			properties.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    //获取key对应的value值
	    String property = properties.getProperty(key);
	    Map<String,Object> map =null ;
	    if(!StringUtils.isEmpty(property)){
	    	try {
				property = new String(property.getBytes("ISO-8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		    String[] key_values = property.split(",");
		    List<Map<String, Object>> listMap=new ArrayList<>();
		    if(key_values!=null&&key_values.length>0){
		    	for(int i=0;i<key_values.length;i++){
		    		map = new HashMap<>();
		    		String[] kv = key_values[i].split(":");
			    	map.put("key", kv[0]);
			    	map.put("value", kv[1]);
			    	listMap.add(map);
		    	}
		    }
		    ObjectMapper objectMapper = new ObjectMapper();
			json = objectMapper.writeValueAsString(listMap);
	    }
	    return json;
	}
      
	
}




