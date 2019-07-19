package com.inca.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class OptionMap {
	static Logger log = LoggerFactory.getLogger(OptionMap.class);
    private static Map<String,Map<Integer,String>> optionMap = new HashMap<>();
    private static Map<String,Map<String,Integer>> optionMap2 = new HashMap<>();
    private static Map<String,String> options = new HashMap<>();
	
    /**
     * 根据key和value获取字段汉字显示
     * @param key
     * @param value
     * @return
     */
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
    /**
     * 根据key(properties=左边为key)和value获取字段汉字显示
     * @param key
     * @param value
     * @return
     */
    public static  Integer getKeyByValue(String key,String value) {
		if(StringUtils.isEmpty(key)||StringUtils.isEmpty(value)){
			return null;
		}
		if(optionMap2.get(key) != null){
			//先从内存中取,没有的话再从文件中取
	        Map<String,Integer> map = optionMap2.get(key);
		    return map.get(value);
		}else{
			Properties properties = new Properties();
		    // 使用ClassLoader加载properties配置文件生成对应的输入流
		    InputStream in = OptionMap.class.getClassLoader().getResourceAsStream("option.properties");
		    // 使用properties对象加载输入流
		    try {
				properties.load(in);
				 //获取key对应的value值
			    String property = properties.getProperty(key);
		        Map<String,Integer> map = new HashMap<>();
		        Integer real_key = null;
			    if(!StringUtils.isEmpty(property)){
			    	try {
						property = new String(property.getBytes("ISO-8859-1"),"utf-8");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				    String[] key_values = property.split(",");
				    for(String key_value:key_values ){
				    	String[] kv = key_value.split(":");
				    	map.put(kv[1],Integer.valueOf(kv[0]));
				    	if(kv[1]!=null&&kv[1].equals(value));
				    	real_key=Integer.valueOf(kv[0]);
				    }
			    }
			    optionMap2.put(key, map);
			    return real_key;
			} catch (IOException e) {
				log.error("get key error:"+e.getMessage());
				e.printStackTrace();
			}
		   
		}
		return null;
		
	}
    /**
     * 根据key和value获取字段汉字显示
     * @param key
     * @param value
     * @return
     * @throws JsonProcessingException 
     */
    public static  String getOptions(String key) throws JsonProcessingException {
		// TODO Auto-generated method stub
		if(StringUtils.isEmpty(key)){
			return "";
		}
		String json=null;
		if(options.get(key) != null){
			//先从内存中取,没有的话再从文件中取
	        String ops = options.get(key);
	        if(ops == null){
	        	return "未定义";
	        }
		    return ops;
		}else{
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
				options.put(key, json);
		    }
		}
	    return json;
	}
	public static void main(String[] args) throws IOException {
		System.out.println(OptionMap.getValue("customertype",2));
	}
}
