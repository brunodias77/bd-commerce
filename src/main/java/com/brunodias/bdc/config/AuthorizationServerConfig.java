package com.brunodias.bdc.config;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.time.Duration;
import java.util.List;
import java.util.UUID;

import com.brunodias.bdc.config.customgrant.CustomPasswordAuthenticationConverter;
import com.brunodias.bdc.config.customgrant.CustomPasswordAuthenticationProvider;
import com.brunodias.bdc.config.customgrant.CustomUserAuthorities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.OAuth2Token;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.oauth2.server.authorization.InMemoryOAuth2AuthorizationConsentService;
import org.springframework.security.oauth2.server.authorization.InMemoryOAuth2AuthorizationService;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationConsentService;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationService;
import org.springframework.security.oauth2.server.authorization.authentication.OAuth2ClientAuthenticationToken;
import org.springframework.security.oauth2.server.authorization.client.InMemoryRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configuration.OAuth2AuthorizationServerConfiguration;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configurers.OAuth2AuthorizationServerConfigurer;
import org.springframework.security.oauth2.server.authorization.settings.AuthorizationServerSettings;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;
import org.springframework.security.oauth2.server.authorization.settings.OAuth2TokenFormat;
import org.springframework.security.oauth2.server.authorization.settings.TokenSettings;
import org.springframework.security.oauth2.server.authorization.token.DelegatingOAuth2TokenGenerator;
import org.springframework.security.oauth2.server.authorization.token.JwtEncodingContext;
import org.springframework.security.oauth2.server.authorization.token.JwtGenerator;
import org.springframework.security.oauth2.server.authorization.token.OAuth2AccessTokenGenerator;
import org.springframework.security.oauth2.server.authorization.token.OAuth2TokenCustomizer;
import org.springframework.security.oauth2.server.authorization.token.OAuth2TokenGenerator;
import org.springframework.security.web.SecurityFilterChain;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;

@Configuration // Indica que esta classe contém configurações de beans do Spring.
public class AuthorizationServerConfig {

	@Value("${application.security.client-id}")
	private String clientId; // Valor do clientId carregado do arquivo de propriedades.

	@Value("${application.security.client-secret}")
	private String clientSecret; // Valor do clientSecret carregado do arquivo de propriedades.

	@Value("${application.security.jwt.duration}")
	private Integer jwtDurationSeconds; // Duração do JWT (em segundos) carregada do arquivo de propriedades.

	@Autowired
	private UserDetailsService userDetailsService; // Injeção de dependência do serviço que lida com os detalhes do usuário.

	@Bean
	@Order(2) // Define a ordem de execução deste filtro de segurança.
	public SecurityFilterChain asSecurityFilterChain(HttpSecurity http) throws Exception {
		// Configura a segurança padrão do Authorization Server.
		OAuth2AuthorizationServerConfiguration.applyDefaultSecurity(http);

		// Configuração do endpoint de token com uma conversão customizada de autenticação.
		http.getConfigurer(OAuth2AuthorizationServerConfigurer.class)
				.tokenEndpoint(tokenEndpoint -> tokenEndpoint
						.accessTokenRequestConverter(new CustomPasswordAuthenticationConverter()) // Conversor customizado para grant-type "password".
						.authenticationProvider(new CustomPasswordAuthenticationProvider(authorizationService(), tokenGenerator(), userDetailsService, passwordEncoder()))); // Provedor customizado de autenticação.

		// Configura o Resource Server para validar os tokens JWT.
		http.oauth2ResourceServer(oauth2ResourceServer -> oauth2ResourceServer.jwt(Customizer.withDefaults()));

		return http.build(); // Constrói a configuração final de segurança.
	}

	@Bean
	public OAuth2AuthorizationService authorizationService() {
		// Serviço em memória para armazenar autorizações.
		return new InMemoryOAuth2AuthorizationService();
	}

	@Bean
	public OAuth2AuthorizationConsentService oAuth2AuthorizationConsentService() {
		// Serviço em memória para armazenar consentimentos de autorização.
		return new InMemoryOAuth2AuthorizationConsentService();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		// Encoder de senha BCrypt para codificar as senhas dos clientes.
		return new BCryptPasswordEncoder();
	}

	@Bean
	public RegisteredClientRepository registeredClientRepository() {
		// Criação de um cliente registrado com escopos, grant-type e configurações de token.
		RegisteredClient registeredClient = RegisteredClient
				.withId(UUID.randomUUID().toString()) // Gera um ID único para o cliente.
				.clientId(clientId) // Define o clientId do cliente.
				.clientSecret(passwordEncoder().encode(clientSecret)) // Codifica e define o clientSecret do cliente.
				.scope("read") // Escopo de leitura.
				.scope("write") // Escopo de escrita.
				.authorizationGrantType(new AuthorizationGrantType("password")) // Tipo de concessão de autorização (password).
				.tokenSettings(tokenSettings()) // Configurações do token.
				.clientSettings(clientSettings()) // Configurações do cliente.
				.build();

		return new InMemoryRegisteredClientRepository(registeredClient); // Armazena o cliente registrado em memória.
	}

	@Bean
	public TokenSettings tokenSettings() {
		// Configura o tempo de vida e formato do token.
		return TokenSettings.builder()
				.accessTokenFormat(OAuth2TokenFormat.SELF_CONTAINED) // Define o formato do token como autossuficiente (JWT).
				.accessTokenTimeToLive(Duration.ofSeconds(jwtDurationSeconds)) // Tempo de expiração do token.
				.build();
	}

	@Bean
	public ClientSettings clientSettings() {
		// Configurações do cliente OAuth2 (aqui podem ser incluídas regras de segurança e permissões).
		return ClientSettings.builder().build();
	}

	@Bean
	public AuthorizationServerSettings authorizationServerSettings() {
		// Configurações do Authorization Server.
		return AuthorizationServerSettings.builder().build();
	}

	@Bean
	public OAuth2TokenGenerator<? extends OAuth2Token> tokenGenerator() {
		// Configura o gerador de tokens JWT com um codificador JWT.
		NimbusJwtEncoder jwtEncoder = new NimbusJwtEncoder(jwkSource());
		JwtGenerator jwtGenerator = new JwtGenerator(jwtEncoder);
		jwtGenerator.setJwtCustomizer(tokenCustomizer()); // Customiza as informações contidas no token.
		OAuth2AccessTokenGenerator accessTokenGenerator = new OAuth2AccessTokenGenerator(); // Gera tokens de acesso.
		return new DelegatingOAuth2TokenGenerator(jwtGenerator, accessTokenGenerator); // Delegação para os geradores de token.
	}

	@Bean
	public OAuth2TokenCustomizer<JwtEncodingContext> tokenCustomizer() {
		// Customiza o token JWT, adicionando claims específicas como "authorities" e "username".
		return context -> {
			OAuth2ClientAuthenticationToken principal = context.getPrincipal();
			CustomUserAuthorities user = (CustomUserAuthorities) principal.getDetails();
			List<String> authorities = user.getAuthorities().stream().map(x -> x.getAuthority()).toList();
			if (context.getTokenType().getValue().equals("access_token")) {
				context.getClaims()
						.claim("authorities", authorities) // Adiciona as authorities no token.
						.claim("username", user.getUsername()); // Adiciona o username no token.
			}
		};
	}

	@Bean
	public JwtDecoder jwtDecoder(JWKSource<SecurityContext> jwkSource) {
		// Decodifica os tokens JWT usando uma chave JWK.
		return OAuth2AuthorizationServerConfiguration.jwtDecoder(jwkSource);
	}

	@Bean
	public JWKSource<SecurityContext> jwkSource() {
		// Gera uma fonte de chaves JWK com uma chave RSA.
		RSAKey rsaKey = generateRsa();
		JWKSet jwkSet = new JWKSet(rsaKey);
		return (jwkSelector, securityContext) -> jwkSelector.select(jwkSet); // Seleciona a chave JWK.
	}

	private static RSAKey generateRsa() {
		// Gera um par de chaves RSA (pública e privada).
		KeyPair keyPair = generateRsaKey();
		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
		RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
		return new RSAKey.Builder(publicKey).privateKey(privateKey).keyID(UUID.randomUUID().toString()).build(); // Cria uma RSAKey com o par de chaves.
	}

	private static KeyPair generateRsaKey() {
		// Gera um par de chaves RSA com tamanho de 2048 bits.
		KeyPair keyPair;
		try {
			KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
			keyPairGenerator.initialize(2048); // Define o tamanho da chave RSA.
			keyPair = keyPairGenerator.generateKeyPair(); // Gera a chave.
		} catch (Exception ex) {
			throw new IllegalStateException(ex); // Lança exceção caso ocorra algum erro.
		}
		return keyPair;
	}
}

