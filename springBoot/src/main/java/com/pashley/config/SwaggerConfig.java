package com.pashley.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**
     * swagger生成接口文档：浏览器输入：http://localhost:port/swagger-ui.html 即可访问文档
     * 注意springboot初始化中Application覆盖的包名需全部覆盖到方法所在包
     * @return
     */
    @Bean
    public Docket api(){
        return  new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .pathMapping("/")
                .select()
                .paths(PathSelectors.regex("/.*"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("pashley的接口文档")
                .contact(new Contact("Pashley","","111111@qq.com"))
                .description("这是swagger生成的接口文档")
                .version("1.0.0.0")
                .build();
    }
}
