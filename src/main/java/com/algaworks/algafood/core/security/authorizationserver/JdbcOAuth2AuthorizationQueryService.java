package com.algaworks.algafood.core.security.authorizationserver;

import java.util.List;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.oauth2.server.authorization.client.JdbcRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;

public class JdbcOAuth2AuthorizationQueryService implements OAuth2AuthorizationQueryService {
	
	private final JdbcOperations jdbcOperations;
	private final RowMapper<RegisteredClient> registeredClientrowMapper;
	
	private final String LIST_AUTHORIZED_CLIENTS = "select rc.* from oauth2_authorization_consent c " +
            "inner join oauth2_registered_client rc on rc.id = c.registered_client_id " +
            "where c.principal_name = ? ";
	
	public JdbcOAuth2AuthorizationQueryService(JdbcOperations jdbcOperations) {
		this.jdbcOperations = jdbcOperations;
		this.registeredClientrowMapper = new JdbcRegisteredClientRepository.RegisteredClientRowMapper();
	}

	@Override
	public List<RegisteredClient> clientsWithConsentList(String principalName) {
		return this.jdbcOperations.query(LIST_AUTHORIZED_CLIENTS, registeredClientrowMapper, principalName);
	}

}
