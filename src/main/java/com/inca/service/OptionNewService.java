package com.inca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface OptionNewService {
	//获取选项字典值
	String getOptionValues(String key) throws Exception;
}
