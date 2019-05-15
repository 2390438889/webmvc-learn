package com.lujie.mvc;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author Hearts
 * @date 2019/5/14
 * @desc
 */
public class MyWebAppInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{MyWebApplicationInit.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
