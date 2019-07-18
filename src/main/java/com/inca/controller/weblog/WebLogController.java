package com.inca.controller.weblog;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inca.entity.system.log.view.WebLogView;
import com.inca.entity.system.log.vo.WebLogVo;
import com.inca.result.PageResult;
import com.inca.service.WebLogService;

@Controller
@RequestMapping(WebLogController.funcPath)
public class WebLogController {
	public static final String funcPath = "/DTA002";
	
	@Autowired
	WebLogService logService;
	@ModelAttribute("funcPath")
    public String funcPath() {
        return funcPath;
    }
	@RequestMapping("/loginhome")
	public String loginLogHome(){
		return "weblog/loginlog";
	}
	@RequestMapping("/accesshome")
	public String accessLogHome(){
		return "weblog/accesslog";
	}
	@RequestMapping("/loginsearch")
	@ResponseBody
	public PageResult<WebLogView> loginSearch(WebLogVo log){
		log.setWebType(1);//登录类型
		//访问开始时间-结束时间
		Date startDate =null;
		Date endDate =null;
		try {
			if (!StringUtils.isEmpty(log.getAccessTimeFrom())) {
				startDate = new SimpleDateFormat("yyyy-MM-dd H:mm:ss").parse(log.getAccessTimeFrom());
			}
			if (!StringUtils.isEmpty(log.getAccessTimeTo())) {
				endDate = new SimpleDateFormat("yyyy-MM-dd H:mm:ss").parse(log.getAccessTimeTo());
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.setStartDate(startDate);
		log.setEndDate(endDate);
		PageResult<WebLogView> logs = logService.getWebLogs(log);
		return logs;
	}
	@RequestMapping("/accesssearch")
	@ResponseBody
	public PageResult<WebLogView> accesssearch(WebLogVo log){
		log.setWebType(2);//接口访问类型
		// 访问开始时间-结束时间
		Date startDate = null;
		Date endDate = null;
		try {
			if (!StringUtils.isEmpty(log.getAccessTimeFrom())) {
				startDate = new SimpleDateFormat("yyyy-MM-dd H:mm:ss").parse(log.getAccessTimeFrom());
			}
			if (!StringUtils.isEmpty(log.getAccessTimeTo())) {
				endDate = new SimpleDateFormat("yyyy-MM-dd H:mm:ss").parse(log.getAccessTimeTo());
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.setStartDate(startDate);
		log.setEndDate(endDate);
		PageResult<WebLogView> logs = logService.getWebLogs(log);
		return logs;
	}
}
 