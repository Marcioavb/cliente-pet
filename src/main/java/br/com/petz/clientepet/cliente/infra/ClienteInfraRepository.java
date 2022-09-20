package br.com.petz.clientepet.cliente.infra;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.com.petz.clientepet.cliente.application.repository.ClienteRepository;
import br.com.petz.clientepet.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class ClienteInfraRepository implements ClienteRepository {
	private final ClienteSpringDataJPARepository clienteSpringDataJPARepository;

	@Override
	public Cliente salva(Cliente cliente) {
		log.info("[inicia] ClienteInfraRepository - salva ");
		clienteSpringDataJPARepository.save(cliente);
		log.info("[finaliza] ClienteInfraRepository - salva ");

		return cliente;
	}

	@Override
	public List<Cliente> buscaTodosclientes() {
		log.info("[inicia] ClienteInfraRepository - buscaTodosclientes ");
		List<Cliente> todosClientes = clienteSpringDataJPARepository.findAll();
		log.info("[finaliza] ClienteInfraRepository - buscaTodosclientes ");
		return todosClientes;
	}

	@Override
	public Cliente buscaClienteAtravezId(UUID idCliente) {
		log.info("[inicia] ClienteInfraRepository - buscaClienteAtravezId ");
		Cliente cliente = clienteSpringDataJPARepository.findByIdCliente(idCliente)
				.orElseThrow(()-> new RuntimeException("Cliente nao encontrado!"));
		log.info("[finaliza] ClienteInfraRepository - buscaClienteAtravezId ");
		return cliente ;
	}

	
	
}
