package com.brunodias.bdc.config.customgrant;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.lang.Nullable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.OAuth2ErrorCodes;
import org.springframework.security.oauth2.core.endpoint.OAuth2ParameterNames;
import org.springframework.security.web.authentication.AuthenticationConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;

import jakarta.servlet.http.HttpServletRequest;

/**
 * Classe CustomPasswordAuthenticationConverter que implementa a interface AuthenticationConverter
 * Esta classe converte uma requisição HTTP em um token de autenticação personalizado para o grant type "password".
 */
public class CustomPasswordAuthenticationConverter implements AuthenticationConverter {

	/**
	 * Converte a requisição HTTP em um objeto de autenticação.
	 * Valida se o grant type é "password" e verifica se os parâmetros obrigatórios (username e password) estão presentes.
	 *
	 * @param request - a requisição HTTP
	 * @return Authentication - token de autenticação personalizado ou null se não for grant type "password"
	 */
	@Nullable
	@Override
	public Authentication convert(HttpServletRequest request) {

		// Obtém o tipo de grant (grant_type) da requisição
		String grantType = request.getParameter(OAuth2ParameterNames.GRANT_TYPE);

		// Se o grant type não for "password", retorna null (este conversor não processa o pedido)
		if (!"password".equals(grantType)) {
			return null;
		}

		// Extrai todos os parâmetros da requisição
		MultiValueMap<String, String> parameters = getParameters(request);

		// Validação do parâmetro opcional "scope"
		String scope = parameters.getFirst(OAuth2ParameterNames.SCOPE);
		if (StringUtils.hasText(scope) &&
				parameters.get(OAuth2ParameterNames.SCOPE).size() != 1) {
			// Lança exceção se houver múltiplos valores de "scope"
			throw new OAuth2AuthenticationException(OAuth2ErrorCodes.INVALID_REQUEST);
		}

		// Validação do parâmetro obrigatório "username"
		String username = parameters.getFirst(OAuth2ParameterNames.USERNAME);
		if (!StringUtils.hasText(username) ||
				parameters.get(OAuth2ParameterNames.USERNAME).size() != 1) {
			// Lança exceção se "username" não for informado ou houver múltiplos valores
			throw new OAuth2AuthenticationException(OAuth2ErrorCodes.INVALID_REQUEST);
		}

		// Validação do parâmetro obrigatório "password"
		String password = parameters.getFirst(OAuth2ParameterNames.PASSWORD);
		if (!StringUtils.hasText(password) ||
				parameters.get(OAuth2ParameterNames.PASSWORD).size() != 1) {
			// Lança exceção se "password" não for informado ou houver múltiplos valores
			throw new OAuth2AuthenticationException(OAuth2ErrorCodes.INVALID_REQUEST);
		}

		// Se houver escopos fornecidos, cria um conjunto de escopos
		Set<String> requestedScopes = null;
		if (StringUtils.hasText(scope)) {
			requestedScopes = new HashSet<>(
					Arrays.asList(StringUtils.delimitedListToStringArray(scope, " ")));
		}

		// Coleta os parâmetros adicionais da requisição
		Map<String, Object> additionalParameters = new HashMap<>();
		parameters.forEach((key, value) -> {
			// Exclui "grant_type" e "scope" dos parâmetros adicionais
			if (!key.equals(OAuth2ParameterNames.GRANT_TYPE) &&
					!key.equals(OAuth2ParameterNames.SCOPE)) {
				additionalParameters.put(key, value.get(0));
			}
		});

		// Obtém o principal do cliente (usuário autenticado)
		Authentication clientPrincipal = SecurityContextHolder.getContext().getAuthentication();

		// Retorna o token de autenticação personalizado
		return new CustomPasswordAuthenticationToken(clientPrincipal, requestedScopes, additionalParameters);
	}

	/**
	 * Método auxiliar que extrai os parâmetros da requisição e os retorna em um MultiValueMap.
	 *
	 * @param request - a requisição HTTP
	 * @return MultiValueMap<String, String> - mapa dos parâmetros da requisição
	 */
	private static MultiValueMap<String, String> getParameters(HttpServletRequest request) {

		// Extrai o mapa de parâmetros da requisição HTTP
		Map<String, String[]> parameterMap = request.getParameterMap();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>(parameterMap.size());

		// Converte o mapa de parâmetros para MultiValueMap
		parameterMap.forEach((key, values) -> {
			if (values.length > 0) {
				for (String value : values) {
					parameters.add(key, value);
				}
			}
		});
		return parameters;
	}
}
