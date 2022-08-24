package com.algaworks.algafood.core.springdoc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;

@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Parameter(in = ParameterIn.QUERY, name="page", description = "Número da página",
	schema = @Schema(type = "integer", defaultValue = "0"))
@Parameter(in = ParameterIn.QUERY, name="size", description = "Quantidade de elementos por página",
	schema = @Schema(type = "integer", defaultValue = "10"))
@Parameter(in = ParameterIn.QUERY, name="sort", description = "Critério de ordenação: propriedade,asc|desc",
	schema = @Schema(type = "string", example="nome_da_propriedade,desc"),
	examples = {
		@ExampleObject("nome"),
		@ExampleObject("nome,asc"),
		@ExampleObject("nome,desc"),
})
public @interface PageableParameter {

}
