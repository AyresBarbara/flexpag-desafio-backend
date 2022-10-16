package com.flexpag.paymentscheduler.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@Configuration
@EnableWebMvc
public class SwaggerConfig implements WebMvcConfigurer {

	 @Bean
	    public Docket api() {
	        return new Docket(DocumentationType.SWAGGER_2).select()
	                .apis(RequestHandlerSelectors.basePackage("com.flexpag.paymentscheduler"))
	                .paths(PathSelectors.regex("/.*"))
	                .build().apiInfo(apiInfoMetaData());
	    }

	    private ApiInfo apiInfoMetaData() {

	        return new ApiInfoBuilder().title("Desafio FlexPag - Desenvolvedor Java Junior")
	                .description("APIREST - Agendamento/ Pagamento")
	                .contact(new Contact("Bárbara Ayres", "https://www.linkedin.com/in/b%C3%A1rbara-ayres-31903118b/", "ayresbarbara2@gmail.com"))
	                .version("1.0.0")
	                .build();
	    }
	}
