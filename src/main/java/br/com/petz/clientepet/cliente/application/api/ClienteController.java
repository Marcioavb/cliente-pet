package br.com.petz.clientepet.cliente.application.api;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RestController;

import br.com.petz.clientepet.cliente.application.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
public class ClienteController implements ClienteApi {
	private final ClienteService clienteService;

	@Override
	public ClienteResponse postCliente(ClienteRequest clienteRequest) {
		log.info("[inicia] ClienteController - postCliente");
		ClienteResponse clienteCriado = clienteService.criaCliente(clienteRequest);
		log.info("[finaliza] ClienteController - postCliente");
		return clienteCriado;
	}
	@Override
	public List<ClienteListResponse> getTodosCliente() {
		log.info("[inicia] ClienteController - getTodosCliente");
		List<ClienteListResponse> clientes = clienteService.buscaTodosClientes();
		log.info("[finaliza] ClienteController - getTodosCliente");
		return clientes;
	}
	@Override
	public ClienteDetalhadoResponse getClienteAtravesId(UUID idCliente) {
		log.info("[inicia] ClienteController - getClienteAtravesId");
		log.info("[idCliente] {}", idCliente);
		ClienteDetalhadoResponse clienteDetalhado = clienteService.buscaClienteAtravesId(idCliente);
		log.info("[finaliza] ClienteController - getClienteAtravesId");
		return clienteDetalhado ;
	}
	@Override
	public void deletaClienteAtravesId(UUID idCliente) {
		log.info("[inicia] ClienteController - deletaClienteAtravesId");
		log.info("[idCliente] {}", idCliente);
		clienteService.deletaClienteAtravesId(idCliente);
		log.info("[finaliza] ClienteController - deletaClienteAtravesId");
	}
	@Override
	public void pachAlteraCliente(UUID idCliente, @Valid ClientealteracaoRequest clientealteracaoRequest) {
		log.info("[inicia] ClienteController - pachAlteraCliente");
		log.info("[idCliente] {}", idCliente);
		log.info("[finaliza] ClienteController - pachAlteraCliente");

	}
	
}
