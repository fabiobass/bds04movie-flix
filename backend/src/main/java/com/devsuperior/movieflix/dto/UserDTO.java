package com.devsuperior.movieflix.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.devsuperior.movieflix.entities.User;

public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotBlank(message = "Campo obrigatório")
 	private Long id;
	
 	@NotBlank(message = "Campo obrigatório")
 	private String name;
 	
 	@Email(message = "Favor entrar um email válido")
 	private String email;


	public UserDTO(Long id, String name, String email, String password) {
		this.id = id;
		this.name = name;
		this.email = email;
	}
	public UserDTO(User entity) {
		id = entity.getId();
		name = entity.getName();
		email = entity.getEmail();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}