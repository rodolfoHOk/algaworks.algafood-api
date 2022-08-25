package com.algaworks.algafood.core.springdoc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.algaworks.algafood.api.exceptionhandler.Problem;

import io.swagger.v3.core.converter.ModelConverters;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.OAuthFlow;
import io.swagger.v3.oas.annotations.security.OAuthFlows;
import io.swagger.v3.oas.annotations.security.OAuthScope;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import io.swagger.v3.oas.models.tags.Tag;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Configuration
@SecurityScheme(name = "security_auth",
	type = SecuritySchemeType.OAUTH2,
	flows = @OAuthFlows(authorizationCode = @OAuthFlow(
			authorizationUrl = "${springdoc.oAuthFlow.authorizationUrl}",
			tokenUrl = "${springdoc.oAuthFlow.tokenUrl}",
			scopes = {
					@OAuthScope(name = "READ", description = "read_scope"),
					@OAuthScope(name = "WRITE", description = "write_scope"),
			}
	)))
public class SpringDocConfig {
	
	private static final String badRequestResponse = "BadRequestResponse";
	private static final String notFoundResponse = "NotFoundResponse";
	private static final String noAcepptableResponse = "NoAcepptableResponse";
	private static final String internalServerError = "InternalServerError";
	
	@Bean
	public OpenAPI openAPI() {
		return new OpenAPI()
				.info(new Info()
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
				).tags(Arrays.asList(
						new Tag().name("Cidades").description("Gerencia as cidades"),
						new Tag().name("Cozinhas").description("Gerencia as cozinhas"),
						new Tag().name("Estados").description("Gerencia os estados"),
						new Tag().name("Estatísticas").description("Estatísticas da AlgaFood"),
						new Tag().name("Formas de pagamento").description("Gerencia as formas de pagamento"),
						new Tag().name("Grupos").description("Gerencia os grupos"),
						new Tag().name("Pedidos").description("Gerencia os pedidos"),
						new Tag().name("Permissões").description("Gerencia as permissões"),
						new Tag().name("Produtos").description("Gerencia os produtos de um restaurante"),
						new Tag().name("Restaurantes").description("Gerencia os restaurantes"),
						new Tag().name("Usuários").description("Gerencia os usuários")
				)).components(new Components()
						.schemas(gerarSchemas())
						.responses(gerarResponses())
				);
	}
	
	@Bean
	public OpenApiCustomiser openApiCustomiser() {
		return openApi -> {
			openApi.getPaths().values().stream()
				.forEach(pathItem -> pathItem.readOperationsMap()
						.forEach((httpMethod, operation) -> {
							ApiResponses responses = operation.getResponses();
							switch (httpMethod) {
								case GET: {
									responses.addApiResponse("406", new ApiResponse().$ref(noAcepptableResponse));
									responses.addApiResponse("500", new ApiResponse().$ref(internalServerError));
									break;
								}
								case POST: {
									responses.addApiResponse("400", new ApiResponse().$ref(badRequestResponse));
									responses.addApiResponse("500", new ApiResponse().$ref(internalServerError));
									break;
								}
								case PUT: {
									responses.addApiResponse("400", new ApiResponse().$ref(badRequestResponse));
									responses.addApiResponse("500", new ApiResponse().$ref(internalServerError));
									break;
								}
								case DELETE: {
									responses.addApiResponse("500", new ApiResponse().$ref(internalServerError));
									break;
								}
								default: {
									responses.addApiResponse("500", new ApiResponse().$ref(internalServerError));
									break;
								}
							}
						})
				);
		};
	}
	
	@SuppressWarnings("rawtypes")
	private Map<String, Schema> gerarSchemas() {
		final Map<String, Schema> schemaMap = new HashMap<>();
		
		Map<String, Schema> problemSchema = ModelConverters.getInstance().read(Problem.class);
		Map<String, Schema> problemObjectSchema = ModelConverters.getInstance().read(Problem.Object.class);
		
		schemaMap.putAll(problemSchema);
		schemaMap.putAll(problemObjectSchema);
		
		return schemaMap;
	}
	
	private Map<String, ApiResponse> gerarResponses() {
		
		Map<String, ApiResponse> apiResponseMap = new HashMap<>();
		
		Content content = new Content().addMediaType(APPLICATION_JSON_VALUE, 
				new MediaType().schema(new Schema<Problem>().$ref("Problema")));
		
		apiResponseMap.put(badRequestResponse, new ApiResponse()
				.description("Requisição inválida")
				.content(content));
		
		apiResponseMap.put(notFoundResponse, new ApiResponse()
				.description("Recurso não encontrado")
				.content(content));
		
		apiResponseMap.put(noAcepptableResponse, new ApiResponse()
				.description("Recurso não possui representação aceita pelo consumidor")
				.content(content));
		
		apiResponseMap.put(internalServerError, new ApiResponse()
				.description("Erro interno no servidor")
				.content(content));
		
		return apiResponseMap;
	}

}
