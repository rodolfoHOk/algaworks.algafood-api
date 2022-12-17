package com.algaworks.algafood;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import com.algaworks.algafood.util.DatabaseCleaner;
import com.algaworks.algafood.util.ResourceUtils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("/application-test.properties")
public class CadastroRestauranteIT {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private DatabaseCleaner databaseCleaner;
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	private static final int RESTAURANTE_ID_INEXISTENTE = 100;
	private static final String TITLE_DADOS_INVALIDOS = "Dados Inválidos";
	private static final String MSG_VIOLACAO_REGRA_NEGOCIO = "Violação de regra de negócio";
	
	private Restaurante restauranteComidaDaFazenda;
	
	@BeforeEach
	public void setup() {
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		RestAssured.port = port;
		RestAssured.basePath = "/restaurantes";
		
		databaseCleaner.clearTables();
		prepararDados();
	}
	
	@Test
	public void deveRetornarStatus200_quandoConsultarRestaurantes() {
		given()
			.accept(ContentType.JSON)
		.when()
			.get()
		.then()
			.statusCode(HttpStatus.OK.value());	
	}
	
	@Test
	public void deveRetornarRespostaEStatusCorretos_quandoConsultarRestauranteExistente() {
		given()
			.pathParam("restauranteId", restauranteComidaDaFazenda.getId())
			.accept(ContentType.JSON)
		.when()
			.get("/{restauranteId}")
		.then()
			.statusCode(HttpStatus.OK.value())
			.body("nome", equalTo(restauranteComidaDaFazenda.getNome()));	
	}
	
	@Test
	public void deveRetornarStatus404_quandoConsultarRestauranteInxistente() {
		given()
			.pathParam("restauranteId", RESTAURANTE_ID_INEXISTENTE)
			.accept(ContentType.JSON)
		.when()
			.get("/{restauranteId}")
		.then()
			.statusCode(HttpStatus.NOT_FOUND.value());
	}
	
	@Test
	public void deveRetornarStatus201_quandoCadastrarRestaurante() {
		String jsonCorretoRestauranteGaucho = ResourceUtils
				.getContentFromResource("/json/correto/restaurante-gaucho.json");
		
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(jsonCorretoRestauranteGaucho)
		.when()
			.post()
		.then()
			.statusCode(HttpStatus.CREATED.value());
	}
	
	@Test
	public void deveRetornarStatus400_quandoCadastrarRestauranteComNomeEmBranco() {
		String jsonRestauranteNomeEmBranco = ResourceUtils
				.getContentFromResource("/json/incorreto/restaurante-nome-branco.json");
		
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(jsonRestauranteNomeEmBranco)
		.when()
			.post()
		.then()
			.statusCode(HttpStatus.BAD_REQUEST.value())
			.body("title", equalTo(TITLE_DADOS_INVALIDOS));
	}
	
	@Test
	public void deveRetornarStatus400_quandoCadastrarRestauranteSemTaxaFrete() {
		String jsonRestauranteSemTaxaFrete = ResourceUtils
				.getContentFromResource("/json/incorreto/restaurante-sem-taxa-frete.json");
		
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(jsonRestauranteSemTaxaFrete)
		.when()
			.post()
		.then()
			.statusCode(HttpStatus.BAD_REQUEST.value())
			.body("title", equalTo(TITLE_DADOS_INVALIDOS));
	}
	
	@Test
	public void deveRetornarStatus400_quandoCadastrarRestauranteTaxaFreteNegativa() {
		String jsonRestauranteTaxaFreteNegativa = ResourceUtils
				.getContentFromResource("/json/incorreto/restaurante-taxa-frete-negativa.json");
		
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(jsonRestauranteTaxaFreteNegativa)
		.when()
			.post()
		.then()
			.statusCode(HttpStatus.BAD_REQUEST.value())
			.body("title", equalTo(TITLE_DADOS_INVALIDOS));
	}
	
	@Test
	public void deveRetornarStatus400_quandoCadastrarRestauranteSemCozinha() {
		String jsonRestauranteSemCozinha = ResourceUtils
				.getContentFromResource("/json/incorreto/restaurante-sem-cozinha.json");
		
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(jsonRestauranteSemCozinha)
		.when()
			.post()
		.then()
			.statusCode(HttpStatus.BAD_REQUEST.value())
			.body("title", equalTo(TITLE_DADOS_INVALIDOS));
	}
	
	@Test
	public void deveRetornarStatus400_quandoCadastrarRestauranteCozinhaInexistente() {
		String jsonRestauranteCozinhaInexistente = ResourceUtils
				.getContentFromResource("/json/incorreto/restaurante-cozinha-inexistente.json");
		
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(jsonRestauranteCozinhaInexistente)
		.when()
			.post()
		.then()
			.statusCode(HttpStatus.BAD_REQUEST.value())
			.body("title", equalTo(MSG_VIOLACAO_REGRA_NEGOCIO));
	}

	private void prepararDados() {
		Cozinha cozinhaBrasileira = new Cozinha();
		cozinhaBrasileira.setNome("Brasileira");
		cozinhaRepository.save(cozinhaBrasileira);
		
		Cozinha cozinhaJaponesa = new Cozinha();
		cozinhaJaponesa.setNome("Japonesa");
		cozinhaRepository.save(cozinhaJaponesa);
		
		restauranteComidaDaFazenda = new Restaurante();
		restauranteComidaDaFazenda.setNome("Comida da Fazenda");
		restauranteComidaDaFazenda.setTaxaFrete(new BigDecimal("12.50"));
		restauranteComidaDaFazenda.setCozinha(cozinhaBrasileira);
		restauranteRepository.save(restauranteComidaDaFazenda);
		
		Restaurante restauranteOnisan = new Restaurante();
		restauranteOnisan.setNome("Onisan Restaurante");
		restauranteOnisan.setTaxaFrete(new BigDecimal("15.90"));
		restauranteOnisan.setCozinha(cozinhaJaponesa);
		restauranteRepository.save(restauranteOnisan);
	}

}
