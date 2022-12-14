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
	public PetResponse postPet(UUID idCliente, PetRequest petRequest) {
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
	@Override
	public PetClienteDetalhadoResponse getPetDoClienteAtravesId(UUID idCliente, UUID idPet) {
		log.info("[start] PetController - getPetClienteAtravesId");
		log.info("[idCliente] {} - [idPet] {}", idCliente, idPet);
		PetClienteDetalhadoResponse pet = petService.buscaPetDoClienteComId(idCliente, idPet);
		log.info("[finish] PetController - getPetClienteAtravesId");
		return pet;
	}
	@Override
	public void deletePetDoClienteAtravesId(UUID idCliente, UUID idPet) {
		log.info("[start] PetController - deletePetDoClienteAtravesId");
		log.info("[idCliente] {} - [idPet] {}", idCliente, idPet);
		petService.deletaPetDoClienteComId(idCliente, idPet);
		log.info("[start] PetController - deletePetDoClienteAtravesId");
		
	}
	@Override
	public void patchPet(UUID idCliente, UUID idPet, @Valid PetAlteracaoRequest petRequest) {
		log.info("[start] PetController - patchPet");
		log.info("[idCliente] {} - [idPet] {}", idCliente, idPet);
		petService.alteraPetDoClienteComId(idCliente, idPet, petRequest);
		log.info("[finish] PetController - patchPet");
	}
}




