package com.algaworks.algafood.core.security.authorizationserver;

import java.util.List;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.oauth2.server.authorization.JdbcOAuth2AuthorizationService;
import org.springframework.security.oauth2.server.authorization.OAuth2Authorization;
import org.springframework.security.oauth2.server.authorization.client.JdbcRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;

public class JdbcOAuth2AuthorizationQueryService implements OAuth2AuthorizationQueryService {
	
	private final JdbcOperations jdbcOperations;
	private final RowMapper<RegisteredClient> registeredClientRowMapper;
	private final RowMapper<OAuth2Authorization> oAuth2AuthorizationRowMapper;
	
	private final String LIST_AUTHORIZED_CLIENTS_QUERY = "select rc.* from oauth2_authorization_consent c " +
            "inner join oauth2_registered_client rc on rc.id = c.registered_client_id " +
            "where c.principal_name = ? ";
	
	private final String LIST_AUTHORIZATIONS_QUERY = "select a.* from oauth2_authorization a " +
            "inner join oauth2_registered_client c on c.id = a.registered_client_id " +
            "where a.principal_name = ? " +
            "and a.registered_client_id  = ? ";
	
	public JdbcOAuth2AuthorizationQueryService(JdbcOperations jdbcOperations, RegisteredClientRepository clientRepository) {
		this.jdbcOperations = jdbcOperations;
		this.registeredClientRowMapper = new JdbcRegisteredClientRepository.RegisteredClientRowMapper();
		this.oAuth2AuthorizationRowMapper = new JdbcOAuth2AuthorizationService.OAuth2AuthorizationRowMapper(clientRepository);
	}

	@Override
	public List<RegisteredClient> listClientsWithConsent(String principalName) {
		return this.jdbcOperations.query(LIST_AUTHORIZED_CLIENTS_QUERY, registeredClientRowMapper, principalName);
	}
	
	@Override
	public List<OAuth2Authorization> listAuthorizations(String principalName, String clientId) {
		return this.jdbcOperations.query(LIST_AUTHORIZATIONS_QUERY, oAuth2AuthorizationRowMapper, principalName, clientId);
	}

}
