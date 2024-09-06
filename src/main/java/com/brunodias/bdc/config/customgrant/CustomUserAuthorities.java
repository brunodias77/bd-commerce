package com.brunodias.bdc.config.customgrant;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class CustomUserAuthorities {

	// Nome de usuário para o qual as autoridades estão associadas
	private String username;

	// Coleção de autoridades (permissões/roles) atribuídas ao usuário
	private Collection<? extends GrantedAuthority> authorities;

	/**
	 * Construtor que cria uma instância de CustomUserAuthorities.
	 *
	 * @param username O nome de usuário.
	 * @param authorities A coleção de autoridades concedidas ao usuário.
	 */
	public CustomUserAuthorities(String username, Collection<? extends GrantedAuthority> authorities) {
		this.username = username;
		this.authorities = authorities;
	}

	/**
	 * Retorna o nome de usuário associado a estas autoridades.
	 *
	 * @return O nome de usuário.
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Retorna a coleção de autoridades (roles/permissões) associadas ao usuário.
	 *
	 * @return Uma coleção de GrantedAuthority.
	 */
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
}
