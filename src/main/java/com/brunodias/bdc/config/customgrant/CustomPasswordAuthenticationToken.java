package com.brunodias.bdc.config.customgrant;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.lang.Nullable;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.server.authorization.authentication.OAuth2AuthorizationGrantAuthenticationToken;

public class CustomPasswordAuthenticationToken extends OAuth2AuthorizationGrantAuthenticationToken {

	private static final long serialVersionUID = 1L;

	// Armazena o nome de usuário fornecido na autenticação
	private final String username;

	// Armazena a senha fornecida na autenticação
	private final String password;

	// Armazena o conjunto de escopos autorizados para essa autenticação
	private final Set<String> scopes;

	/**
	 * Construtor que cria um token de autenticação customizado para o grant type "password".
	 *
	 * @param clientPrincipal A autenticação do cliente (client principal).
	 * @param scopes O conjunto de escopos autorizados (pode ser nulo).
	 * @param additionalParameters Parâmetros adicionais como nome de usuário e senha.
	 */
	public CustomPasswordAuthenticationToken(Authentication clientPrincipal,
											 @Nullable Set<String> scopes, @Nullable Map<String, Object> additionalParameters) {

		// Chama o construtor da classe pai, passando o tipo de grant, o cliente autenticado e parâmetros adicionais
		super(new AuthorizationGrantType("password"), clientPrincipal, additionalParameters);

		// Extrai o nome de usuário dos parâmetros adicionais
		this.username = (String) additionalParameters.get("username");

		// Extrai a senha dos parâmetros adicionais
		this.password = (String) additionalParameters.get("password");

		// Define o conjunto imutável de escopos autorizados
		this.scopes = Collections.unmodifiableSet(
				scopes != null ? new HashSet<>(scopes) : Collections.emptySet());
	}

	/**
	 * Retorna o nome de usuário associado ao token.
	 *
	 * @return O nome de usuário.
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * Retorna a senha associada ao token.
	 *
	 * @return A senha.
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Retorna o conjunto de escopos autorizados para essa autenticação.
	 *
	 * @return Um conjunto imutável de escopos.
	 */
	public Set<String> getScopes() {
		return this.scopes;
	}
}
