package com.lujie.mvc;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.io.IOException;
import java.util.Properties;

/**
 * @author Hearts
 * @date 2019/5/14
 * @desc
 */
@Configuration
@ComponentScan("com.lujie.mvc")
@EnableWebMvc
public class WebConfig {

    /*@Bean
    public InternalResourceViewResolver jspViewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }*/

    /**
     * 设置freemarker配置文件路径
     * @return
     */
    @Bean
    public PropertiesFactoryBean propertiesFactoryBean(){
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource("conf/freemarker.properties"));
        return propertiesFactoryBean;
    }

    /**
     * 配置freemarker模板路径
     * @return
     */
    @Bean
    public FreeMarkerConfigurer freeMarkerConfigurer(PropertiesFactoryBean propertiesFactoryBean){
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        try {
            freeMarkerConfigurer.setFreemarkerSettings(propertiesFactoryBean.getObject());
        } catch (IOException e) {
            e.printStackTrace();
        }
        freeMarkerConfigurer.setTemplateLoaderPath("/WEB-INF/pages/");
        return freeMarkerConfigurer;
    }
    /**
     * 配置freemarker视图解析器
     * @return
     */
    @Bean
    public FreeMarkerViewResolver freeMarkerViewResolver(){
        FreeMarkerViewResolver freeMarkerViewResolver = new FreeMarkerViewResolver();
        freeMarkerViewResolver.setViewClass(FreeMarkerView.class);
        freeMarkerViewResolver.setContentType("text/html;charset=utf-8");
        freeMarkerViewResolver.setCache(true);
        freeMarkerViewResolver.setSuffix(".ftl");
        return freeMarkerViewResolver;
    }
}
