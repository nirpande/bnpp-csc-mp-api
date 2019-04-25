package com.bnp.csc.api.config;

import org.apache.bval.jsr.ApacheValidationProvider;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.sql.DataSource;

@Configuration
public class DefaultConfig {

    @Value("${apiGateway.jndiName}")
    private String jndiName;

    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean(){
        LocalValidatorFactoryBean validatorBean = new LocalValidatorFactoryBean();
        validatorBean.setProviderClass( ApacheValidationProvider.class);
        return validatorBean;
    }

    @Bean
    @Primary
    @Profile("dev")
    public DataSource dataSource() {
        JndiDataSourceLookup jndiDataSourceLookup = new JndiDataSourceLookup();
        jndiDataSourceLookup.setResourceRef(true);
        return jndiDataSourceLookup.getDataSource(jndiName);
    }
}
