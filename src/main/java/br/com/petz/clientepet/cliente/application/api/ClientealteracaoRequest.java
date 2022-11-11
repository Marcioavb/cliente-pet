package br.com.petz.clientepet.cliente.application.api;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import br.com.petz.clientepet.cliente.domain.Sexo;
import lombok.Value;

@Value
public class ClientealteracaoRequest {

	@NotNull
	private String nomeCompleto;
	@NotNull
	private String celular;
	private String telefone;
	private Sexo sexo;
	@NotNull
	private LocalDate dataNascimento;
	
	@NotNull
	private boolean aceitaTermos;
	public @NotNull boolean getAceitaTermos() {
		return true;
	}
}
