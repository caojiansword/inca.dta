package com.inca.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInteceptor implements HandlerInterceptor{
private final Logger logger = LoggerFactory.getLogger(LoginInteceptor.class);

@Override
public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
	 logger.info("访问资源:"+request.getRequestURI());
	 HttpSession session = request.getSession();
	  Object loginName = session.getAttribute("loginName");
      if (null == loginName || !(loginName instanceof String)) {
          // 未登录，重定向到登录页
          response.sendRedirect("/");
          return false;
      }
     
//      //session持续时间
//      int maxInactiveInterval = session.getMaxInactiveInterval();
//     //session创建时间
//      long creationTime = session.getCreationTime();
//      //session最新链接时间
//      long lastAccessedTime = session.getLastAccessedTime();
//
//      System.out.println("-----> maxInactiveInterval: "+maxInactiveInterval);
//      System.out.println("-----> creationTime: "+creationTime);
//      System.out.println("-----> lastAccessedTime: "+lastAccessedTime);
//
//      //从session获取上次链接时间
//      Long operateTime = (Long)session.getAttribute("operateTime");
//      System.out.println("-----> operateTime: "+operateTime);
//
//      //如果operateTime是空，说明是第一次链接，对operateTime进行初始化
//      if(operateTime ==null){
//          session.setAttribute("operateTime",lastAccessedTime);
//          return true;
//      }else{
//      //计算最新链接时间和上次链接时间的差值
//          int intervalTime = (int)((lastAccessedTime - operateTime)/1000);
//          System.out.println("-----> intervalTime: "+intervalTime);
//          //如果超过十秒没有交互的话，就跳转到超时界面
//          if(intervalTime>10){
//        	  response.sendRedirect("/");
//              return true;
//          }
//          //更新operateTime
//          session.setAttribute("operateTime",lastAccessedTime);
//      }
      return true;
}
}
