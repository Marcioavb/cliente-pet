package br.com.petz.clientepet.cliente.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.petz.clientepet.cliente.application.api.ClienteDetalhadoResponse;
import br.com.petz.clientepet.cliente.application.api.ClienteListResponse;
import br.com.petz.clientepet.cliente.application.api.ClienteRequest;
import br.com.petz.clientepet.cliente.application.api.ClienteResponse;
import br.com.petz.clientepet.cliente.application.api.ClientealteracaoRequest;
import br.com.petz.clientepet.cliente.application.repository.ClienteRepository;
import br.com.petz.clientepet.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class ClienteApplicationService implements ClienteService {
	private final ClienteRepository clienteRepository;

	@Override
	public ClienteResponse criaCliente(ClienteRequest clienteRequest) {
		log.info("[inicia] ClienteApplicastionService - criaCliente");
		Cliente cliente = clienteRepository.salva(new Cliente(clienteRequest));
		log.info("[finaliza] ClienteApplicastionService - criaCliente");
		return ClienteResponse.builder().idCliente(cliente.getIdCliente()).build();
	}
	@Override
	public List<ClienteListResponse> buscaTodosClientes() {
		log.info("[inicia] ClienteApplicastionService - buscaTodosClientes");
		List<Cliente> clientes = clienteRepository.buscaTodosclientes();
		log.info("[finaliza] ClienteApplicastionService - buscaTodosClientes");
		return ClienteListResponse.converte(clientes);
	}
	@Override
	public ClienteDetalhadoResponse buscaClienteAtravesId(UUID idCliente) {
		log.info("[inicia] ClienteApplicastionService - buscaClienteAtravezId");
		Cliente cliente = clienteRepository.buscaClienteAtravesId(idCliente);
		log.info("[finaliza] ClienteApplicastionService - buscaClienteAtravezId");
		return new ClienteDetalhadoResponse(cliente);
	}
	@Override
	public void deletaClienteAtravesId(UUID idCliente) {
		log.info("[inicia] ClienteApplicastionService - deletaClienteAtravesId");
		Cliente cliente = clienteRepository.buscaClienteAtravesId(idCliente);
		clienteRepository.deletaCliente(cliente);
		log.info("[finaliza] ClienteApplicastionService - deletaClienteAtravesId");

	}
	@Override
	public void pachAlteraCliente(UUID idCliente, ClientealteracaoRequest clientealteracaoRequest) {
		log.info("[inicia] ClienteApplicastionService - pachAlteraCliente");
		Cliente cliente = clienteRepository.buscaClienteAtravesId(idCliente);
		cliente.altera (clientealteracaoRequest);
		clienteRepository.salva(cliente);
		log.info("[finaliza] ClienteApplicastionService - pachAlteraCliente");
	}
}

