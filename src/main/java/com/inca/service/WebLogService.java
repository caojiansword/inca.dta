package com.inca.service;

import java.util.List;

import com.inca.entity.system.log.WebLog;

public interface WebLogService {
	/**
	 * 获取日志列表
	 * @param log
	 * @return
	 */
	List<WebLog> getWebLogs(WebLog log);
	/**
	 * 保存日志
	 * @param log
	 */
	void save(WebLog log);
}
