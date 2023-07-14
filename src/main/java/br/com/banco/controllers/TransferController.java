package br.com.banco.controllers;

import br.com.banco.domain.transfer.TransferRepository;
import br.com.banco.infra.TransferResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transferencia")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TransferController {

	@Autowired
	private TransferRepository repository;

	@GetMapping
	public List<TransferResponseDTO> getAll() {
		List<TransferResponseDTO> transferList = repository.findAll().stream().map(TransferResponseDTO::new).toList();
		return transferList;
	}

	@GetMapping("/nome/{nomeOperadorTransacao}")
	public ResponseEntity<List<TransferResponseDTO>> getAllByNomeOperadorTransacao(@PathVariable String nomeOperadorTransacao){
		return ResponseEntity.ok(repository.findAllByNomeOperadorTransacaoContainingIgnoreCase(nomeOperadorTransacao).stream().map(TransferResponseDTO::new).toList());
	}

	@GetMapping("/data/{dataTransferencia}")
	public ResponseEntity<List<TransferResponseDTO>> getAllByDataTransferencia(@PathVariable String dataTransferencia){
		return ResponseEntity.ok(repository.findAllByDataTransferenciaContainingIgnoreCase(dataTransferencia).stream().map(TransferResponseDTO::new).toList());
	}

	@GetMapping("nome/{nomeOperadorTransacao}/data/{dataTransferencia}")
	public ResponseEntity<List<TransferResponseDTO>> getAllByNomeOperadorAndDataTransferencia (
		@PathVariable String nomeOperadorTransacao,
		@PathVariable String dataTransferencia
){
		return ResponseEntity.ok(
			repository.findAllByNomeOperadorTransacaoAndDataTransferenciaContainingIgnoreCase(
				nomeOperadorTransacao,
				dataTransferencia)
			.stream().map(TransferResponseDTO::new).toList());
	}
}
