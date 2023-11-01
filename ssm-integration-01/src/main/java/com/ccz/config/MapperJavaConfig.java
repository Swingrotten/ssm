package com.ccz.config;

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.logging.slf4j.Slf4jImpl;
import org.apache.ibatis.session.AutoMappingBehavior;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class MapperJavaConfig {

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource){
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        /**
         * TODO:开启驼峰式映射
         */
        configuration.setMapUnderscoreToCamelCase(true);
        /**
         * TODO:开启日志
         */
        configuration.setLogImpl(Slf4jImpl.class);
        /**
         * TODO:开启resultMap自动映射
         */
        configuration.setAutoMappingBehavior(AutoMappingBehavior.FULL);

        sqlSessionFactoryBean.setConfiguration(configuration);
        /**
         * TODO:设置别名
         */
        sqlSessionFactoryBean.setTypeAliasesPackage("com.ccz.pojo");
        /**
         * TODO:设置分页插件
         */
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect","mysql");
        pageInterceptor.setProperties(properties);
        sqlSessionFactoryBean.addPlugins(pageInterceptor);

        return sqlSessionFactoryBean;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.ccz.mapper");
        return mapperScannerConfigurer;
    }

}
