package com.inca.controller.weblog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
		PageResult<WebLogView> logs = logService.getWebLogs(log);
		return logs;
	}
}
 