package com.inca.service;

import java.util.List;

import com.inca.entity.system.log.WebLog;
import com.inca.entity.system.log.view.WebLogView;
import com.inca.entity.system.log.vo.WebLogVo;

public interface WebLogService {
	/**
	 * 获取日志列表
	 * @param log
	 * @return
	 */
	List<WebLogView> getWebLogs(WebLogVo log);
	/**
	 * 保存日志
	 * @param log
	 */
	void save(WebLog log);
}
