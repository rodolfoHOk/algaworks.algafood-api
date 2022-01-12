package com.algaworks.algafood.core.openapi;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Links;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping;

import com.algaworks.algafood.api.exceptionhandler.Problem;
import com.algaworks.algafood.api.v1.model.CidadeModel;
import com.algaworks.algafood.api.v1.model.CidadeResumoModel;
import com.algaworks.algafood.api.v1.model.CozinhaModel;
import com.algaworks.algafood.api.v1.model.EnderecoModel;
import com.algaworks.algafood.api.v1.model.EstadoModel;
import com.algaworks.algafood.api.v1.model.FormaPagamentoModel;
import com.algaworks.algafood.api.v1.model.FotoProdutoModel;
import com.algaworks.algafood.api.v1.model.GrupoModel;
import com.algaworks.algafood.api.v1.model.PedidoModel;
import com.algaworks.algafood.api.v1.model.PedidoResumoModel;
import com.algaworks.algafood.api.v1.model.PermissaoModel;
import com.algaworks.algafood.api.v1.model.ProdutoModel;
import com.algaworks.algafood.api.v1.model.RestauranteApenasNomeModel;
import com.algaworks.algafood.api.v1.model.RestauranteBasicoModel;
import com.algaworks.algafood.api.v1.model.RestauranteModel;
import com.algaworks.algafood.api.v1.model.UsuarioModel;
import com.algaworks.algafood.api.v1.openapi.model.CidadeModelOpenApi;
import com.algaworks.algafood.api.v1.openapi.model.CidadeResumoModelOpenApi;
import com.algaworks.algafood.api.v1.openapi.model.CidadesModelOpenApi;
import com.algaworks.algafood.api.v1.openapi.model.CozinhaModelOpenApi;
import com.algaworks.algafood.api.v1.openapi.model.CozinhasModelOpenApi;
import com.algaworks.algafood.api.v1.openapi.model.EnderecoModelOpenApi;
import com.algaworks.algafood.api.v1.openapi.model.EstadoModelOpenApi;
import com.algaworks.algafood.api.v1.openapi.model.EstadosModelOpenApi;
import com.algaworks.algafood.api.v1.openapi.model.FormaPagamentoModelOpenApi;
import com.algaworks.algafood.api.v1.openapi.model.FormasPagamentoModelOpenApi;
import com.algaworks.algafood.api.v1.openapi.model.FotoProdutoModelOpenApi;
import com.algaworks.algafood.api.v1.openapi.model.GrupoModelOpenApi;
import com.algaworks.algafood.api.v1.openapi.model.GruposModelOpenApi;
import com.algaworks.algafood.api.v1.openapi.model.LinksModelOpenApi;
import com.algaworks.algafood.api.v1.openapi.model.PageableModelOpenApi;
import com.algaworks.algafood.api.v1.openapi.model.PedidoModelOpenApi;
import com.algaworks.algafood.api.v1.openapi.model.PedidoResumoModelOpenApi;
import com.algaworks.algafood.api.v1.openapi.model.PedidosResumoModelOpenApi;
import com.algaworks.algafood.api.v1.openapi.model.PermissaoModelOpenApi;
import com.algaworks.algafood.api.v1.openapi.model.PermissoesModelOpenApi;
import com.algaworks.algafood.api.v1.openapi.model.ProdutoModelOpenApi;
import com.algaworks.algafood.api.v1.openapi.model.ProdutosModelOpenApi;
import com.algaworks.algafood.api.v1.openapi.model.RestauranteApenasNomeModelOpenApi;
import com.algaworks.algafood.api.v1.openapi.model.RestauranteBasicoModelOpenApi;
import com.algaworks.algafood.api.v1.openapi.model.RestauranteModelOpenApi;
import com.algaworks.algafood.api.v1.openapi.model.RestaurantesModelOpenApi;
import com.algaworks.algafood.api.v1.openapi.model.UsuarioModelOpenApi;
import com.algaworks.algafood.api.v1.openapi.model.UsuariosModelOpenApi;
import com.algaworks.algafood.api.v2.model.CidadeModelV2;
import com.algaworks.algafood.api.v2.model.CozinhaModelV2;
import com.algaworks.algafood.api.v2.openapi.model.CidadeModelV2OpenApi;
import com.algaworks.algafood.api.v2.openapi.model.CidadesModelV2OpenApi;
import com.algaworks.algafood.api.v2.openapi.model.CozinhaModelV2OpenApi;
import com.algaworks.algafood.api.v2.openapi.model.CozinhasModelV2OpenApi;
import com.fasterxml.classmate.TypeResolver;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RepresentationBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.schema.AlternateTypeRules;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Response;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.json.JacksonModuleRegistrar;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.spring.web.plugins.WebFluxRequestHandlerProvider;
import springfox.documentation.spring.web.plugins.WebMvcRequestHandlerProvider;

@Configuration
// @Import(BeanValidatorPluginsConfiguration.class) springfox 3.0.0 não é mais necessário já é padrâo
public class SpringFoxConfig {
	
	@Bean // Para resolver o problema de serialização de OffsetDateTime
	public JacksonModuleRegistrar springfoxJacksonConfig() {
		return objectMapper -> objectMapper.registerModule(new JavaTimeModule());
	}	
	
	@Bean // bean necessário springfox 3.0.0 issues in springboot 2.6.0+
	public static BeanPostProcessor springfoxHandlerProviderBeanPostProcessor() {
	    return new BeanPostProcessor() {

	        @Override
	        public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
	            if (bean instanceof WebMvcRequestHandlerProvider || bean instanceof WebFluxRequestHandlerProvider) {
	                customizeSpringfoxHandlerMappings(getHandlerMappings(bean));
	            }
	            return bean;
	        }

	        private <T extends RequestMappingInfoHandlerMapping> void customizeSpringfoxHandlerMappings(List<T> mappings) {
	            List<T> copy = mappings.stream()
	                    .filter(mapping -> mapping.getPatternParser() == null)
	                    .collect(Collectors.toList());
	            mappings.clear();
	            mappings.addAll(copy);
	        }

	        @SuppressWarnings("unchecked")
	        private List<RequestMappingInfoHandlerMapping> getHandlerMappings(Object bean) {
	            try {
	                Field field = ReflectionUtils.findField(bean.getClass(), "handlerMappings");
	                field.setAccessible(true);
	                return (List<RequestMappingInfoHandlerMapping>) field.get(bean);
	            } catch (IllegalArgumentException | IllegalAccessException e) {
	                throw new IllegalStateException(e);
	            }
	        }
	    };
	}
	
	@Bean
	public Docket apiDocketV1() {
		var typeResolver = new TypeResolver();
		
		return new Docket(DocumentationType.OAS_30)
				.groupName("V1")
				.select()
					.apis(RequestHandlerSelectors.basePackage("com.algaworks.algafood.api"))
					.paths(PathSelectors.ant("/v1/**"))
					.build()
				.useDefaultResponseMessages(false)
				.globalResponses(HttpMethod.GET, globalGetResponses())
				.globalResponses(HttpMethod.POST, globalPutResponses())
				.globalResponses(HttpMethod.PUT, globalPutResponses())
				.globalResponses(HttpMethod.DELETE, globalDeleteResponses())
				.additionalModels(typeResolver.resolve(Problem.class))
				.ignoredParameterTypes(ServletWebRequest.class)
				.directModelSubstitute(Pageable.class, PageableModelOpenApi.class)
				.directModelSubstitute(Links.class, LinksModelOpenApi.class)
				.directModelSubstitute(CidadeModel.class, CidadeModelOpenApi.class)
				.directModelSubstitute(CidadeResumoModel.class, CidadeResumoModelOpenApi.class)
				.directModelSubstitute(CozinhaModel.class, CozinhaModelOpenApi.class)
				.directModelSubstitute(EnderecoModel.class, EnderecoModelOpenApi.class)
				.directModelSubstitute(EstadoModel.class, EstadoModelOpenApi.class)
				.directModelSubstitute(FormaPagamentoModel.class, FormaPagamentoModelOpenApi.class)
				.directModelSubstitute(GrupoModel.class, GrupoModelOpenApi.class)
				.directModelSubstitute(PermissaoModel.class, PermissaoModelOpenApi.class)
				.directModelSubstitute(RestauranteApenasNomeModel.class, RestauranteApenasNomeModelOpenApi.class)
				.directModelSubstitute(UsuarioModel.class, UsuarioModelOpenApi.class)
				.directModelSubstitute(PedidoModel.class, PedidoModelOpenApi.class)
				.directModelSubstitute(PedidoResumoModel.class, PedidoResumoModelOpenApi.class)
				.directModelSubstitute(ProdutoModel.class, ProdutoModelOpenApi.class)
				.directModelSubstitute(FotoProdutoModel.class, FotoProdutoModelOpenApi.class)
				.directModelSubstitute(RestauranteModel.class, RestauranteModelOpenApi.class)
				.directModelSubstitute(RestauranteBasicoModel.class, RestauranteBasicoModelOpenApi.class)
				.apiInfo(apiInfoV1())
				.alternateTypeRules(AlternateTypeRules.newRule(
						typeResolver.resolve(PagedModel.class, CozinhaModel.class), CozinhasModelOpenApi.class))
				.alternateTypeRules(AlternateTypeRules.newRule(
						typeResolver.resolve(PagedModel.class, PedidoResumoModel.class), 
						PedidosResumoModelOpenApi.class))
				.alternateTypeRules(AlternateTypeRules.newRule(
						typeResolver.resolve(CollectionModel.class, CidadeModel.class), CidadesModelOpenApi.class))
				.alternateTypeRules(AlternateTypeRules.newRule(
						typeResolver.resolve(CollectionModel.class, EstadoModel.class), EstadosModelOpenApi.class))
				.alternateTypeRules(AlternateTypeRules.newRule(
					    typeResolver.resolve(CollectionModel.class, FormaPagamentoModel.class),
					    FormasPagamentoModelOpenApi.class))
				.alternateTypeRules(AlternateTypeRules.newRule(
						typeResolver.resolve(CollectionModel.class, GrupoModel.class), GruposModelOpenApi.class))
				.alternateTypeRules(AlternateTypeRules.newRule(
						typeResolver.resolve(CollectionModel.class, PermissaoModel.class), 
						PermissoesModelOpenApi.class))
				.alternateTypeRules(AlternateTypeRules.newRule(
						typeResolver.resolve(CollectionModel.class, ProdutoModel.class), ProdutosModelOpenApi.class))
				.alternateTypeRules(AlternateTypeRules.newRule(
						typeResolver.resolve(CollectionModel.class, RestauranteBasicoModel.class),
						RestaurantesModelOpenApi.class))
				.alternateTypeRules(AlternateTypeRules.newRule(
						typeResolver.resolve(CollectionModel.class, UsuarioModel.class),
						UsuariosModelOpenApi.class))
				.tags(new Tag("Cidades", "Gerencia as cidades"),
						new Tag("Grupos", "Gerencia os grupos de usuários"),
						new Tag("Cozinhas", "Gerencia as cozinhas"),
						new Tag("Formas de Pagamento", "Gerencia as formas de pagamento"),
						new Tag("Pedidos", "Gerencia os pedidos"),
						new Tag("Restaurantes", "Gerencia os restaurantes"),
						new Tag("Estados", "Gerencia os estados"),
						new Tag("Produtos", "Gerencia os produtos de um restaurante"),
						new Tag("Usuários", "Gerencia os usuários"),
						new Tag("Estatísticas", "Estatísticas da AlgaFood"),
						new Tag("Permissões", "Gerencia as permissões"));
	}
	
	@Bean
	public Docket apiDocketV2() {
		var typeResolver = new TypeResolver();
		
		return new Docket(DocumentationType.OAS_30)
				.groupName("V2")
				.select()
					.apis(RequestHandlerSelectors.basePackage("com.algaworks.algafood.api"))
					.paths(PathSelectors.ant("/v2/**"))
					.build()
				.useDefaultResponseMessages(false)
				.globalResponses(HttpMethod.GET, globalGetResponses())
				.globalResponses(HttpMethod.POST, globalPutResponses())
				.globalResponses(HttpMethod.PUT, globalPutResponses())
				.globalResponses(HttpMethod.DELETE, globalDeleteResponses())
				.additionalModels(typeResolver.resolve(Problem.class))
				.ignoredParameterTypes(ServletWebRequest.class)
				.directModelSubstitute(Pageable.class, PageableModelOpenApi.class)
				.directModelSubstitute(Links.class, LinksModelOpenApi.class)
				.directModelSubstitute(CidadeModelV2.class, CidadeModelV2OpenApi.class)
				.directModelSubstitute(CozinhaModelV2.class, CozinhaModelV2OpenApi.class)
				.alternateTypeRules(AlternateTypeRules.newRule(
						typeResolver.resolve(CollectionModel.class, CidadeModelV2.class),
						CidadesModelV2OpenApi.class))
				.alternateTypeRules(AlternateTypeRules.newRule(
						typeResolver.resolve(PagedModel.class, CozinhaModelV2.class),
						CozinhasModelV2OpenApi.class))
				.apiInfo(apiInfoV2())
				.tags(
						new Tag("Cidades", "Gerencia as cidades"),
						new Tag("Cozinhas", "Gerencia as cozinhas")
				);
	}
	
	private List<Response> globalDeleteResponses() {
		return Arrays.asList(
					new ResponseBuilder()
						.code(String.valueOf(HttpStatus.BAD_REQUEST.value()))
						.description("Requisição inválida (erro do cliente)")
						.representation(MediaType.APPLICATION_JSON)
						.apply(getProblemModelReference())
						.build(),
					new ResponseBuilder()
						.code(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
						.description("Erro interno do servidor")
						.representation(MediaType.APPLICATION_JSON)
						.apply(getProblemModelReference())
						.build()
				);
	}

	private List<Response> globalPutResponses() {
		return Arrays.asList(
					new ResponseBuilder()
						.code(String.valueOf(HttpStatus.BAD_REQUEST.value()))
						.description("Requisição inválida (erro do cliente)")
						.representation(MediaType.APPLICATION_JSON)
						.apply(getProblemModelReference())
						.build(),
					new ResponseBuilder()
						.code(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
						.description("Erro interno do servidor")
						.representation(MediaType.APPLICATION_JSON)
						.apply(getProblemModelReference())
						.build(),
					new ResponseBuilder()
						.code(String.valueOf(HttpStatus.NOT_ACCEPTABLE.value()))
						.description("Recurso não possui representação que possa ser aceita pelo consumidor")
						.build(),
					new ResponseBuilder()
						.code(String.valueOf(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value()))
						.description("Requisição recusada porque o corpo está em um formato não suportado")
						.representation(MediaType.APPLICATION_JSON)
						.apply(getProblemModelReference())
						.build()
				);
	}

	private List<Response> globalGetResponses() {
		return Arrays.asList(
					new ResponseBuilder()
						.code(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
						.description("Erro interno do servidor")
						.representation(MediaType.APPLICATION_JSON)
						.apply(getProblemModelReference())
						.build(),
					new ResponseBuilder()
						.code(String.valueOf(HttpStatus.NOT_ACCEPTABLE.value()))
						.description("Recurso não possui representação que possa ser aceita pelo consumidor")
						.build()						
				);
	}
	
	private Consumer<RepresentationBuilder> getProblemModelReference() {
		return representation -> representation.model(model -> model.name("Problema")
					.referenceModel(ref -> ref.key(key -> key.qualifiedModelName(
							qModel -> qModel.name("Problema").namespace(
									"com.algaworks.algafood.api.exceptionhandler")))));
	}
	
	private ApiInfo apiInfoV1() {
		return new ApiInfoBuilder()
				.title("AlgaFood API")
				.description("API aberta para clientes e restaurantes")
				.version("1")
				.contact(new Contact("AlgaWorks", "https://www.algaworks.com", "contato@algaworks.com"))
				.build();
	}
	
	private ApiInfo apiInfoV2() {
		return new ApiInfoBuilder()
				.title("AlgaFood API")
				.description("API aberta para clientes e restaurantes")
				.version("2")
				.contact(new Contact("AlgaWorks", "https://www.algaworks.com", "contato@algaworks.com"))
				.build();
	}
	
}
