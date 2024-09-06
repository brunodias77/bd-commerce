package com.brunodias.bdc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class ResourceServerConfig {

	// Lê o valor da origem permitida para CORS do arquivo de configuração
	@Value("${application.cors.origins}")
	private String corsOrigins;

	/**
	 * Configura uma cadeia de filtros de segurança para o console H2 (somente no perfil "test").
	 * Desativa CSRF e as opções de frame, permitindo o uso do H2-console no modo de teste.
	 */
	@Bean
	@Profile("test")
	@Order(1)  // Define a ordem da cadeia de segurança (importante para múltiplas cadeias)
	public SecurityFilterChain h2SecurityFilterChain(HttpSecurity http) throws Exception {
		// Configura o HttpSecurity para permitir o acesso ao console do H2 sem CSRF e sem restrições de frame
		http.securityMatcher(PathRequest.toH2Console())
				.csrf(csrf -> csrf.disable())
				.headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable()));
		return http.build();
	}

	/**
	 * Configura a cadeia de filtros de segurança para o servidor de recursos.
	 * Desativa CSRF, permite todas as requisições e configura suporte a autenticação JWT.
	 */
	@Bean
	@Order(2)  // Ordem secundária para esta cadeia de segurança
	public SecurityFilterChain rsSecurityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())  // Desativa proteção contra CSRF
				.authorizeHttpRequests(authorize -> authorize.anyRequest().permitAll())  // Permite todas as requisições
				.oauth2ResourceServer(oauth2ResourceServer -> oauth2ResourceServer.jwt(Customizer.withDefaults()))  // Ativa o suporte a autenticação JWT
				.cors(cors -> cors.configurationSource(corsConfigurationSource()));  // Ativa o suporte a CORS
		return http.build();
	}

	/**
	 * Configura o conversor de autenticação JWT para extrair autoridades (roles) do token JWT.
	 * Remove o prefixo "ROLE_" das autoridades, permitindo a aplicação de permissões diretamente.
	 */
	@Bean
	public JwtAuthenticationConverter jwtAuthenticationConverter() {
		JwtGrantedAuthoritiesConverter grantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
		// Define o nome do campo de autoridades no token JWT
		grantedAuthoritiesConverter.setAuthoritiesClaimName("authorities");
		// Remove o prefixo "ROLE_" das autoridades
		grantedAuthoritiesConverter.setAuthorityPrefix("");

		JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
		// Usa o conversor configurado para extrair as autoridades do token
		jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(grantedAuthoritiesConverter);
		return jwtAuthenticationConverter;
	}

	/**
	 * Configura o suporte a CORS, permitindo que a aplicação receba requisições de origens externas específicas.
	 */
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);  // Permite envio de credenciais (cookies, autenticações)
		config.addAllowedOrigin(corsOrigins);  // Permite a origem especificada no arquivo de configuração
		config.addAllowedHeader("*");  // Permite todos os cabeçalhos
		config.addAllowedMethod("*");  // Permite todos os métodos HTTP (GET, POST, etc.)
		source.registerCorsConfiguration("/**", config);  // Aplica essa configuração para todas as rotas da aplicação
		return source;
	}
}
