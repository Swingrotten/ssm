package com.ccz.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@EnableWebMvc
@Configuration
@ComponentScan({"com.ccz.controller"})
public class WebMvcJavaConfig  implements WebMvcConfigurer {

    /**
     *TODO:静态资源实现
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * TODO:视图解析器实现
     * @param registry
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("WEB-INF/views/","jsp");
    }

    /**
     * TODO:拦截器实现
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

    }
}
