package br.com.petz.clientepet.pet.application.api;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RestController;

import br.com.petz.clientepet.pet.application.service.PetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequiredArgsConstructor
@RestController
@Log4j2
public class PetController implements PetAPI {
	private final PetService petService;

	@Override
	public PetResponse postPet(UUID idCliente, @Valid PetRequest petRequest) {
		log.info("[start] PetController - postPet");
		log.info("[idCliente] {}", idCliente);
		PetResponse pet = petService.criaPet (idCliente, petRequest);
		log.info("[finish] PetController - postPet");
		return pet;
	}

	@Override
	public List<PetClienteListResponse> getPetsDoClienteComId(UUID idCliente) {
		log.info("[start] PetController - getPetsDoClienteComId");
		log.info("[idCliente] {}", idCliente);
		List<PetClienteListResponse> petsDoCliente = 
				petService.buscaPetsDoClienteComId(idCliente);
		log.info("[finish] PetController - getPetsDoClienteComId");
		return petsDoCliente;
	}
}
