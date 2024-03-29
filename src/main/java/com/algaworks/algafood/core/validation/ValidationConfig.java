package com.algaworks.algafood.core.validation;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;


// Na versão do spring boot 2.6.1 não é necessária esta configuração.
// O messages.properties já aceitava por padrão os jakarta.validation.constraints.
@Configuration
public class ValidationConfig {
	
	@Bean
	public LocalValidatorFactoryBean validator(MessageSource messageSource) {
		LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
		bean.setValidationMessageSource(messageSource);
		
		return bean;
	}
	
}
