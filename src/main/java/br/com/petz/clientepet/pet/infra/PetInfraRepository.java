package br.com.petz.clientepet.pet.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import br.com.petz.clientepet.handler.APIException;
import br.com.petz.clientepet.pet.application.repository.PetRepository;
import br.com.petz.clientepet.pet.domain.Pet;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequiredArgsConstructor
@Repository
@Log4j2
public class PetInfraRepository implements PetRepository {
	private final PetSpringDataJPARepository petSpringDataJPARepository;

	@Override
	public Pet salvaPet(Pet pet) {
		log.info("[start] PetInfraRepository - salvaPet");
		petSpringDataJPARepository.save(pet);
		log.info("[finish] PetInfraRepository - salvaPet");
		return pet;
	}

	@Override
	public List<Pet> buscaPetsDoClienteComId(UUID idCliente) {
		log.info("[start] PetInfraRepository - buscaPetsDoClienteComId");
		var pets = petSpringDataJPARepository.findByIdClienteTutor(idCliente);
		log.info("[finish] PetInfraRepository - buscaPetsDoClienteComId");
		return pets;
	}

	@Override
	public Pet buscaPetPeloId(UUID idPet) {
		log.info("[start] PetInfraRepository - buscaPetPeloId");
		var pet = petSpringDataJPARepository.findById(idPet).orElseThrow(
				() -> APIException.build(HttpStatus.NOT_FOUND, "pet nao encontrado para o idPet = " + idPet));
		log.info("[finish] PetInfraRepository - buscaPetPeloId");
		return pet;
	}

	@Override
	public void deletaPet(Pet pet) {
		log.info("[start] PetInfraRepository - deletaPet");
		petSpringDataJPARepository.delete(pet);
		log.info("[finish] PetInfraRepository - deletaPet");
	}

}
