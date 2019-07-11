package com.inca.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.inca.interceptor.LoginInteceptor;

@Configuration
public class LoginConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器
    	LoginInteceptor loginInterceptor = new LoginInteceptor();
        InterceptorRegistration loginRegistry = registry.addInterceptor(loginInterceptor);
        // 拦截路径
        loginRegistry.addPathPatterns("/**");
        
        // 排除路径
        loginRegistry.excludePathPatterns("/");
        loginRegistry.excludePathPatterns("/submitlogin");
        loginRegistry.excludePathPatterns("/login");
        loginRegistry.excludePathPatterns("/getGifCode");
        loginRegistry.excludePathPatterns("/loginout");
        loginRegistry.excludePathPatterns("/incayjc/**");

        //过滤静态资源（废弃使用，由addResourceHandlers方法处理）
//        loginRegistry.excludePathPatterns("/css/**");
//        loginRegistry.excludePathPatterns("/img/**");
//        loginRegistry.excludePathPatterns("/js/**");
//        loginRegistry.excludePathPatterns("/font/**");
//        loginRegistry.excludePathPatterns("/fonts/**");
//        loginRegistry.excludePathPatterns("/kindeditor/**");
//        loginRegistry.excludePathPatterns("/lib/**");
//        loginRegistry.excludePathPatterns("/error/**");
//        loginRegistry.excludePathPatterns("/login/**");
    }
    /**
     * 添加静态资源文件，外部可以直接访问地址
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //需要配置1：----------- 需要告知系统，这是要被当成静态文件的！
        //第一个方法设置访问路径前缀，第二个方法设置资源路径 !!!一定要加啊,否则css页面引入不进来,导致css js丢失,页面很难看
        registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/static/");
    }
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

}
