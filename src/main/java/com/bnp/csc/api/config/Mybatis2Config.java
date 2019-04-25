package com.bnp.csc.api.config;

import com.bnp.scm.services.limitmgmt.dao.ILimitCheckDAO;
import com.bnp.scm.services.limitmgmt.dao.LimitCheckDAOImpl;
import com.ibatis.sqlmap.client.SqlMapClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.orm.ibatis.SqlMapClientFactoryBean;

import javax.sql.DataSource;

@Configuration
public class Mybatis2Config {

    @Value("classpath:SqlMapConfig.xml")
    private Resource mybatis2ConfigResource;


    /**
     *       <bean id="sqlMap" class="org.springframework.orm.ibatis.SqlMapClientFactoryBean">
     *               <property name="configLocation" value="classpath:SqlMapConfig.xml"/>
     *               <property name="dataSource" ref="dataSource" />
     *        </bean>
     */
    @Bean
    public SqlMapClient sqlMapClientFactory( DataSource dataSource ) throws Exception
    {
        SqlMapClientFactoryBean result = new SqlMapClientFactoryBean();
        result.setDataSource( dataSource );
        result.setConfigLocation( mybatis2ConfigResource );
        result.afterPropertiesSet();
        return result.getObject();
    }

    @Bean
    public ILimitCheckDAO limitCheckDAO( SqlMapClient sqlMapClient, DataSource dataSource )
    {
        LimitCheckDAOImpl limitCheckDAO = new LimitCheckDAOImpl();
        limitCheckDAO.setDataSource( dataSource );
        limitCheckDAO.setSqlMapClient( sqlMapClient );
        return limitCheckDAO;
    }
}
