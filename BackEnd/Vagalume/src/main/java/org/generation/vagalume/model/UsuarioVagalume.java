package org.generation.vagalume.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_usuariosvagalume")
public class UsuarioVagalume {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "O campo Nome Completo é Obrigatório! ")
	private String nomecompleto;
	
	@NotNull(message = "O campo E-mail é Obrigatório! ")
	@Email(message = "O campo Usuário deve ser um e-mail válido! ")
	private String usuarios;
	
	@NotBlank(message = "O campo senha é Obrigatório! ")
	@Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres")
	private String senha;
	
	@Size(max = 5000, message = "O link da foto não pode ser maior que 5000 caracteres")
	private String foto;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuario")
	private List<PostagemVagalume> postagem;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomecompleto() {
		return nomecompleto;
	}

	public void setNomecompleto(String nomecompleto) {
		this.nomecompleto = nomecompleto;
	}

	public String getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(String usuarios) {
		this.usuarios = usuarios;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public List<PostagemVagalume> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<PostagemVagalume> postagem) {
		this.postagem = postagem;
	}
}	

