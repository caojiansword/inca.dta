package com.inca.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.inca.entity.system.log.WebLog;

@Repository
public interface WebLogMapper {
	List<WebLog> getWebLogs(WebLog log);
	void insert(WebLog log);
}
