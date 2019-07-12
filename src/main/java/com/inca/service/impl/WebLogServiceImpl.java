package com.inca.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inca.entity.system.log.WebLog;
import com.inca.mapper.WebLogMapper;
import com.inca.service.WebLogService;
@Service
public class WebLogServiceImpl implements WebLogService {
	Log logger = LogFactory.getLog(WebLogServiceImpl.class);
	@Autowired
	WebLogMapper mapper;

	@Override
	public List<WebLog> getWebLogs(WebLog log) {
		return null;
	}
	
	@Override
	@Transactional
	public void save(WebLog log) {
		logger.info(log);
		this.mapper.insert(log);
	}

}
