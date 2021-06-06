package com.publicis.starwarsclient;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * starwars application which is springboot application as a starting point.
 * EnableZuulProxy is to use zuul for load balancing. In addition it has other functionalities also.
 * Enable Discovery client is to register eureka server.
 *
 * @author Sridhar
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
@OpenAPIDefinition(info = @Info(title = "Starwars API", version = "1.0", description = "Documentation Starwars API v1.0"))
public class StarWarsClientApplication {

	/**
	 * Main method which is entrypoint for spring boot app
	 *
	 * @param args runtime argument
	 */
	public static void main(String[] args) {
		SpringApplication.run(StarWarsClientApplication.class, args);
	}

	/**
	 * bean for swagger
	 *
	 * @return Docket
	 */
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.publicis.starwarsclient.controller"))
				.paths(PathSelectors.any())
				.build().apiInfo(new ApiInfo("StarWars Service Api Documentation", "Documentation automatically generated", "1.0", null, new Contact("Sridhar", "", "sridhar2193@gmail.com"), null, null));
	}

}
