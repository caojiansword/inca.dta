package com.inca.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.inca.entity.system.log.WebLog;
import com.inca.entity.system.log.view.WebLogView;
import com.inca.entity.system.log.vo.WebLogVo;
import com.inca.mapper.WebLogMapper;
import com.inca.result.PageResult;
import com.inca.service.WebLogService;
@Service
public class WebLogServiceImpl implements WebLogService {
	Log logger = LogFactory.getLog(WebLogServiceImpl.class);
	@Autowired
	WebLogMapper mapper;

	@Override
	public PageResult<WebLogView> getWebLogs(WebLogVo log) {
		PageHelper.startPage(log.getPageIndex(), log.getPageSize());
		List<WebLogView> list = this.mapper.getWebLogs(log);
		PageInfo<WebLogView> pageInfo = new PageInfo<>(list,log.getPageSize());
		PageResult<WebLogView> pageResult = new  PageResult<>();
		pageResult.setData(pageInfo.getList());
		pageResult.setTotal(pageInfo.getTotal());
		return pageResult;
	}
 	
	@Override
	@Transactional
	public void save(WebLog log) {
		logger.info(log);
		this.mapper.insert(log);
	}

}
