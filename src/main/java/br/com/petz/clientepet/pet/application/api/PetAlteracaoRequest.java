package br.com.petz.clientepet.pet.application.api;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.petz.clientepet.pet.domain.Porte;
import br.com.petz.clientepet.pet.domain.TipoPet;
import br.com.petz.clientepet.pet.domain.sexoPet;
import lombok.Value;

@Value
public class PetAlteracaoRequest {
	@NotBlank
	private String nomePet;
	private Porte porte;
	@NotNull
	private TipoPet tipo;
	private String microchip;
	@NotBlank
	private String raca;
	@NotNull
	private sexoPet sexo;
	private String pelagemCor;
	@NotNull
	private LocalDate dataNascimento;
	private String rga;
	private String peso ;

}
