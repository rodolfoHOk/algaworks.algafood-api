package com.algaworks.algafood.core.springdoc;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SpringDocConfig {
	
//	@Bean
//	public OpenAPI openAPI() {
//		return new OpenAPI()
//				.info(new Info()
//						.title("AlgaFood API")
//						.version("v1")
//						.description("REST API do AlgaFood")
//						.license(new License()
//								.name("Apache 2.0")
//								.url("https://springdoc.org")
//						)
//				).externalDocs(new ExternalDocumentation()
//						.description("AlgaWorks")
//						.url("https://algaworks.com")
//				);
//	}
	
	@Bean
	public GroupedOpenApi groupedOpenApi() {
		return GroupedOpenApi.builder()
				.group("AlgaFood API")
				.pathsToMatch("/v1/**")
				.addOpenApiCustomiser(openApi -> {
					openApi.info(new Info()
							.title("AlgaFood API")
							.version("v1")
							.description("REST API do AlgaFood")
							.license(new License()
									.name("Apache 2.0")
									.url("https://springdoc.org")
							)
					).externalDocs(new ExternalDocumentation()
							.description("AlgaWorks")
							.url("https://algaworks.com")
					);
				})
				.build();
	}
	
	@Bean
	public GroupedOpenApi groupedOpenApiV2() {
		return GroupedOpenApi.builder()
				.group("AlgaFood API V2")
				.pathsToMatch("/v2/**")
				.addOpenApiCustomiser(openApi -> {
					openApi.info(new Info()
							.title("AlgaFood API V2")
							.version("v2")
							.description("REST API do AlgaFood V2")
							.license(new License()
									.name("Apache 2.0")
									.url("https://springdoc.org")
							)
					).externalDocs(new ExternalDocumentation()
							.description("AlgaWorks")
							.url("https://algaworks.com")
					);
				})
				.build();
	}

}
