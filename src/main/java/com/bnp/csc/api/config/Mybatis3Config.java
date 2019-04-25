package com.bnp.csc.api.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;

@Configuration
@MapperScan("com.bnp.csc.services.common.dao")
public class Mybatis3Config {

    @Value("classpath:mybatis-config.xml")
    private Resource mybatisConfigResource;

    /**
     *        <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
     *               <property name="dataSource" ref="dataSource" />
     *               <property name="configLocation" value="classpath:mybatis-config.xml"/>
     *        </bean>
     *
     * @param dataSource
     * @return
     */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean( DataSource dataSource )
    {
        SqlSessionFactoryBean result = new SqlSessionFactoryBean();
        result.setDataSource( dataSource );
        result.setConfigLocation( mybatisConfigResource );
        return result;
    }



}
