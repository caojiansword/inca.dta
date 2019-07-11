package com.inca.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

public class OptionMap {
	static Logger log = LoggerFactory.getLogger(OptionMap.class);
    private static Map<String,Map<Integer,String>> optionMap = new HashMap<>();
	public static  String getValue(String key,Integer value) {
		if(StringUtils.isEmpty(key)||StringUtils.isEmpty(value)){
			return "";
		}
		if(optionMap.get(key) != null){
			//先从内存中取,没有的话再从文件中取
	        Map<Integer,String> map = optionMap.get(key);
	        if(map == null){
	        	return "未定义";
	        }
		    return map.get(value)==null?"未定义":map.get(value);
		}else{
			Properties properties = new Properties();
		    // 使用ClassLoader加载properties配置文件生成对应的输入流
		    InputStream in = OptionMap.class.getClassLoader().getResourceAsStream("option.properties");
		    // 使用properties对象加载输入流
		    try {
				properties.load(in);
				 //获取key对应的value值
			    String property = properties.getProperty(key);
		        Map<Integer,String> map = new HashMap<>();
			    if(!StringUtils.isEmpty(property)){
			    	try {
						property = new String(property.getBytes("ISO-8859-1"),"utf-8");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				    String[] key_values = property.split(",");
				    for(String key_value:key_values ){
				    	String[] kv = key_value.split(":");
				    	map.put(Integer.valueOf(kv[0]), kv[1]);
				    }
			    }
			    optionMap.put(key, map);
			    String view = map.get(value)==null?"未定义":map.get(value);
			    return view;
			} catch (IOException e) {
				log.error("get option error:"+e.getMessage());
				e.printStackTrace();
			}
		   
		}
		return String.valueOf(value);
		
	}
	public static void main(String[] args) throws IOException {
		System.out.println(OptionMap.getValue("customertype",2));
	}
}
