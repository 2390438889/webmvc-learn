package com.lujie.mvc;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author Hearts
 * @date 2019/5/14
 * @desc
 */
public class MyWebApplicationInit implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        //将AppConfig配置添加到Web服务中
        AnnotationConfigWebApplicationContext applicationContext=new AnnotationConfigWebApplicationContext();
        applicationContext.register(WebConfig.class);
        applicationContext.setServletContext(servletContext);
        applicationContext.refresh();
        ServletRegistration.Dynamic registration =servletContext.addServlet("dispatcher",new DispatcherServlet(applicationContext));
        registration.addMapping("/");
        registration.setLoadOnStartup(1);
    }
}
