package com.inca.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.inca.entity.system.log.WebLog;
import com.inca.entity.system.log.view.WebLogView;
import com.inca.entity.system.log.vo.WebLogVo;

@Repository
public interface WebLogMapper {
	List<WebLogView> getWebLogs(WebLogVo log);
	void insert(WebLog log);
}
