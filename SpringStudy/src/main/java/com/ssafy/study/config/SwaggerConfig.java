 package com.ssafy.study.config;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssafy.study.dto.MemDTO;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


//Swagger 설정 확인
//http://localhost:8000/{your-app-root}/v2/api-docs
//Swagger-UI 확인
//http://localhost:port/{your-app-root}/swagger-ui.html

//http://localhost:8000/swagger-ui.html

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket postApi() {
		List<ResponseMessage> responseMessages = new ArrayList<ResponseMessage>();
		responseMessages.add(new ResponseMessageBuilder().code(200).message("OK !!!").build());//정상
		responseMessages.add(new ResponseMessageBuilder().code(500).message("서버 문제 발생 !!!").responseModel(new ModelRef("Error")).build());//서버오류
		responseMessages.add(new ResponseMessageBuilder().code(404).message("페이지를 찾을 수 없습니다 !!!").build());//404
		
		return new Docket(DocumentationType.SWAGGER_2)
		.consumes(getConsumeContentTypes()).produces(getProduceContentTypes())
		.apiInfo(info()).groupName("Version").select()
		.apis(RequestHandlerSelectors.basePackage("com.ssafy.study.controller"))
		.paths(PathSelectors.ant("/api/**"))
		.build()
		.useDefaultResponseMessages(false)
		.globalResponseMessage(RequestMethod.GET,responseMessages);
	}
	
	public ApiInfo info() {
		return new ApiInfoBuilder()
				.title("API 문서입니다")
				.license("SSAFY + ayj")
				.version("0.9")
				.build();
	}
	
	private Set<String> getConsumeContentTypes() {//넘어오는 데이터
        Set<String> consumes = new HashSet<>();
        consumes.add("application/json;charset=UTF-8");
        consumes.add("application/xml;charset=UTF-8");
        consumes.add("application/x-www-form-urlencoded");
        return consumes;
    }

    private Set<String> getProduceContentTypes() {//보내주는 데이터
        Set<String> produces = new HashSet<>();
        produces.add("application/json;charset=UTF-8");
        return produces;
    }
    
    
	
	
}
