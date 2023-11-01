package com.ccz.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringIocInit extends AbstractAnnotationConfigDispatcherServletInitializer {


    //rootIoc容器的配置类
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{MapperJavaConfig.class, ServiceJavaConfig.class,DataSourceJavaConfig.class};
    }


    //webIoc容器的配置类
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebMvcJavaConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
