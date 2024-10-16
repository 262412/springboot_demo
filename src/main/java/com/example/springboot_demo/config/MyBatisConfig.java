//package com.example.springboot_demo.config;
//
//import com.github.pagehelper.PageInterceptor;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.Properties;
//
//@Configuration
//public class MyBatisConfig {
//
//    @Bean
//    public SqlSessionFactory sqlSessionFactory() throws Exception {
//        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
//
//        // 配置分页拦截器
//        PageInterceptor pageInterceptor = new PageInterceptor();
//        Properties properties = new Properties();
//        properties.setProperty("helperDialect", "mysql");
//        properties.setProperty("reasonable", "true");
//        pageInterceptor.setProperties(properties);
//
//        factoryBean.setPlugins(pageInterceptor);
//        return factoryBean.getObject();
//    }
//}
//
//}
//
