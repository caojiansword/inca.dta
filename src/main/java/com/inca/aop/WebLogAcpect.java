package com.inca.aop;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.inca.entity.system.log.WebLog;
import com.inca.service.WebLogService;

/**
 * 访问监控切面
 * @author caojian 2019-07-11
 *
 */
@Aspect
@Component
public class WebLogAcpect {
	 private Logger logger = LoggerFactory.getLogger(WebLogAcpect.class);
	 @Autowired
	 WebLogService logService;
	 @Autowired
	 WebLog webLog;
	    /**
	     * 定义切入点，切入点为com.inca.controll.api下目录及子目录所有类和所有方法,参数任意
	     */
	    @Pointcut("execution(public * com.inca.controller.api.yjc.*.*(..))")
	    public void webLog(){}
	    /**
	     * 定义切入点，切入点为com.inca.controll.api下目录及子目录所有类和所有方法,参数任意
	     */
	    @Pointcut("execution(public * com.inca.controller.login.LoginController.submitlogin(..))")
	    public void webLogin(){}

	    /**
	     * 前置通知：在连接点之前执行的通知
	     * @param joinPoint
	     * @throws Throwable
	     */
//	    @Before("webLog()")
//	    public void doBefore(JoinPoint joinPoint) throws Throwable {
//	        // 接收到请求，记录请求内容
//	        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//	        HttpServletRequest request = attributes.getRequest();
//
//	        // 记录下请求内容
//	        logger.info("URL : " + request.getRequestURL().toString());
//	        logger.info("HTTP_METHOD : " + request.getMethod());
//	        logger.info("IP : " + request.getRemoteAddr());
//	        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
//	        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
//	    }

//	    @AfterReturning(returning = "ret",pointcut = "webLog()")
//	    public  void  doAfterReturning(Object ret) throws Throwable {
//		// 处理完请求，返回内容
//	        logger.info("RESPONSE : " + JSON.toJSONString(ret));
//	    }
	    @Around("webLogin()")
	    public Object doLoginAround(ProceedingJoinPoint joinPoint){
	    	return doProcess(joinPoint, 1);//1为登录日志
	    }
	    @Around("webLog()")
	    public Object doWebAccessAround(ProceedingJoinPoint joinPoint){
	    	return doProcess(joinPoint, 2);//2为接口访问日志
	    }
	    
	    private Object doProcess(ProceedingJoinPoint joinPoint,Integer webType){
	    	Object[] args = joinPoint.getArgs();
    	    Signature signature = joinPoint.getSignature();
    	    String methodName = signature.getName();
    	    String methodPath = joinPoint.getSignature().getDeclaringTypeName();
    	    List<Object> list = Arrays.asList(args);
    	    ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
	        HttpServletRequest request = attributes.getRequest();
	        String ip = request.getRemoteAddr();
	        String URL = request.getRequestURL().toString();
	        boolean isSuccess = true;
	        Object result = null;
	        String msg = "调用成功";
    	    try {
	    	    //目标方法之前要执行的操作
	    	    logger.info("[环绕日志]"+methodName+"开始执行，参数为:"+list);
	    	    //调用目标方法
	    	    result = joinPoint.proceed(args);
	    	    //目标方法正常执行之后的操作
	    	    logger.info("[环绕日志]"+methodName+"返回，返回值为:"+result);
    	    
    	    } catch (Throwable e) {
	    	    //目标方法抛出异常信息之后的操作
	    	    logger.info("[环绕日志]"+methodName+"出异常了，异常对象为:"+e);
	    	    msg = e.getMessage();
	    	    isSuccess = false;
	    	    throw new RuntimeException(e.getMessage());
    	    
    	    }finally{
    	    //方法最终结束时执行的操作！
    	    	synchronized (webLog) {
    	    		 webLog.setAccessTime(new Date());
    	    	     webLog.setCreateTime(new Date());
    	    	     webLog.setIp(ip);
    	    	     webLog.setWebType(webType);
    	    	     webLog.setUrl(URL);
    	    	     webLog.setMethodPath(methodPath);
    	    	     webLog.setMethodName(methodName);
    	    	     webLog.setArgs(webType==1?args[1].toString():args.toString());
    	    	     webLog.setResult(isSuccess);
    	    	     webLog.setMsg(msg);
        	         logService.save(webLog);
				}
    	    }
    	    return result;
	    }
}
