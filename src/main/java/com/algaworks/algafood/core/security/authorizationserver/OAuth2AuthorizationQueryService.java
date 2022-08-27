package com.algaworks.algafood.core.security.authorizationserver;

import java.util.List;

import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;

public interface OAuth2AuthorizationQueryService {

	List<RegisteredClient> clientsWithConsentList(String principalName);
	
}
