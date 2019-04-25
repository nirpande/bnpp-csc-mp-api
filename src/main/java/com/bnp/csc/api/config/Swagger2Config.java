package com.bnp.csc.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers( ResourceHandlerRegistry registry) {

        registry
                .addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry
                .addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Bean
    public Docket createRestApi() {
        return new Docket( DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis( RequestHandlerSelectors.basePackage("com.bnp.csc.api"))
                .paths( PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("CSC FO Supply Chain Utilization Management API")
                .description("This is a PoC API Simulating CSC FO Supply Chain Utilization Management API")
                .termsOfServiceUrl( "https://cscfo.com/terms-of-use" )
                .version("1.0")
                .contact( new Contact("Supply Chain FO POC API", "cscfo.com", "stanimir.iakov@bnpparibas.com" ) )
                .license( "BNN Paribas Commerical License" )
                .licenseUrl("http://cscfo.com")
                .build();
    }

}
