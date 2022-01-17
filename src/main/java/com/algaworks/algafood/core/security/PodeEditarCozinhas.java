package com.algaworks.algafood.core.security;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.security.access.prepost.PreAuthorize;

@PreAuthorize("hasAuthority('EDITAR_COZINHAS')")
@Retention(RUNTIME)
@Target(METHOD)
public @interface PodeEditarCozinhas {
	
}
