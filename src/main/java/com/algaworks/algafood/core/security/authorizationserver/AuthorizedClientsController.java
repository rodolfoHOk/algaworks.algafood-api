package com.algaworks.algafood.core.security.authorizationserver;

import java.security.Principal;
import java.util.List;

import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AuthorizedClientsController {

	private final OAuth2AuthorizationQueryService oAuth2AuthorizationQueryService;
	
	@GetMapping("/oauth2/authorized-clients")
	public String clientList(Principal principal, Model model) {
		List<RegisteredClient> clientsWithConsent = oAuth2AuthorizationQueryService
				.clientsWithConsentList(principal.getName());
		
		model.addAttribute("clients", clientsWithConsent);
		
		return "pages/authorized-clients";
	}
	
}
