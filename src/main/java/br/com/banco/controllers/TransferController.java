package br.com.banco.controllers;

import br.com.banco.domain.transfer.Transfer;
import br.com.banco.domain.transfer.TransferRepository;
import br.com.banco.infra.TransferResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/transferencias")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TransferController {

	@Autowired
	private TransferRepository repository;

	// Lista de todas as transferencias sem filtro
	@GetMapping
	public List<TransferResponseDTO> getAll() {
		List<TransferResponseDTO> transferList = repository.findAll().stream().map(TransferResponseDTO::new).toList();
		return transferList;
	}

	// Lista de todas as transferencias por ID da conta
	@GetMapping("/conta/{contaId}")
	public ResponseEntity<List<TransferResponseDTO>> getAllByContaId(@PathVariable Integer contaId){
		return ResponseEntity.ok(repository.findAllByContaId(contaId).stream().map(TransferResponseDTO::new).toList());
	}

	// Lista de todas as transferencias pelo nome do operador de transação
	@GetMapping("/operador/{nomeOperadorTransacao}")
	public ResponseEntity<List<TransferResponseDTO>> getAllByNomeOperadorTransacao(@PathVariable String nomeOperadorTransacao){
		return ResponseEntity.ok(repository.findAllByNomeOperadorTransacaoContainingIgnoreCase(nomeOperadorTransacao).stream().map(TransferResponseDTO::new).toList());
	}

	// Lista de todas as transferencias por período de tempo e / ou operador
	@GetMapping("/filtro")
	public ResponseEntity<List<Transfer>> getAllWithFilter(
			@RequestParam("inicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicio,
			@RequestParam("fim") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFim,
			@RequestParam(value = "conta", required = false) Integer contaId,
			@RequestParam(value = "operador", required = false) String nomeOperadorTransacao) {
		LocalDateTime inicio = dataInicio.atStartOfDay();
		LocalDateTime fim = dataFim.atTime(LocalTime.MAX);
		List<Transfer> transferencias;

		if (contaId != null && nomeOperadorTransacao != null) {
			transferencias = repository.findAllByDataTransferenciaBetweenAndContaIdAndNomeOperadorTransacaoIgnoreCase(
					inicio, fim, contaId, nomeOperadorTransacao);
		} else if (contaId != null) {
			transferencias = repository.findAllByDataTransferenciaBetweenAndContaId(
					inicio, fim, contaId);
		} else if (nomeOperadorTransacao != null) {
			transferencias = repository.findAllByDataTransferenciaBetweenAndNomeOperadorTransacaoIgnoreCase(
					inicio, fim, nomeOperadorTransacao);
		} else {
			transferencias = repository.findAllByDataTransferenciaBetween(inicio, fim);
		}

		return ResponseEntity.ok(transferencias);
	}
}
