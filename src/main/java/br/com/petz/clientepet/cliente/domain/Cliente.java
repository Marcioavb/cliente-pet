package br.com.petz.clientepet.cliente.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.beans.factory.annotation.Value;

import br.com.petz.clientepet.cliente.application.api.ClienteRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, unique = true, nullable = false)
	private UUID idCliente;
	@NotNull
	private String nomeCompleto;
	@NotNull
	@Email
	private String email;
	@NotNull
	private String celular;
	private String telefone;
	private Sexo sexo;
	@NotNull
	private LocalDate dataNascimento;
	@CPF
	private String cpf;
	
	@NotNull
	private boolean aceitaTermos;
	
	private LocalDateTime datahoraDoCadastro;
	private LocalDateTime dataHoraDaUltimaAlteracao;

	public Cliente(ClienteRequest clienteRequest) {
		this.nomeCompleto =  clienteRequest.getNomeCompleto();
		this.email = clienteRequest.getEmail();
		this.celular = clienteRequest.getCelular();
		this.telefone = clienteRequest.getTelefone();
		this.sexo = clienteRequest.getSexo();
		this.dataNascimento = clienteRequest.getDataNascimento();
		this.cpf = clienteRequest.getCpf();
		this.aceitaTermos = clienteRequest.getAceitaTermos();
		this.datahoraDoCadastro = LocalDateTime.now();
	}
}

