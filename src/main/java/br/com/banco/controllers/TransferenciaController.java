package br.com.banco.controllers;

import br.com.banco.domain.transferencia.Transferencia;
import br.com.banco.domain.transferencia.TransferenciaRepository;
import br.com.banco.infra.TransferenciaResponseDTO;
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
public class TransferenciaController {

	@Autowired
	private TransferenciaRepository transferenciaRepository;

	// Lista de todas as transferencias sem filtro
	@GetMapping
	public List<TransferenciaResponseDTO> getAll() {
		List<TransferenciaResponseDTO> transferList = transferenciaRepository.findAll().stream().map(TransferenciaResponseDTO::new).toList();
		return transferList;
	}

	// Lista de todas as transferencias por ID da conta
	@GetMapping("/conta/{contaId}")
	public ResponseEntity<List<TransferenciaResponseDTO>> getAllByContaId(@PathVariable Integer contaId){
		return ResponseEntity.ok(transferenciaRepository.findAllByContaId(contaId).stream().map(TransferenciaResponseDTO::new).toList());
	}

	// Lista de todas as transferencias pelo nome do operador de transação
	@GetMapping("/operador/{nomeOperadorTransacao}")
	public ResponseEntity<List<TransferenciaResponseDTO>> getAllByNomeOperadorTransacao(@PathVariable String nomeOperadorTransacao){
		return ResponseEntity.ok(transferenciaRepository.findAllByNomeOperadorTransacaoContainingIgnoreCase(nomeOperadorTransacao).stream().map(TransferenciaResponseDTO::new).toList());
	}

	// Lista de todas as transferencias por período de tempo e / ou operador
	@GetMapping("/filtro")
	public ResponseEntity<List<Transferencia>> getAllWithFilter(
			@RequestParam("inicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicio,
			@RequestParam("fim") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFim,
			@RequestParam(value = "conta", required = false) Integer contaId,
			@RequestParam(value = "operador", required = false) String nomeOperadorTransacao) {
		LocalDateTime inicio = dataInicio.atStartOfDay();
		LocalDateTime fim = dataFim.atTime(LocalTime.MAX);
		List<Transferencia> transferencias;

		if (contaId != null && nomeOperadorTransacao != null) {
			transferencias = transferenciaRepository.findAllByDataTransferenciaBetweenAndContaIdAndNomeOperadorTransacaoIgnoreCase(
					inicio, fim, contaId, nomeOperadorTransacao);
		} else if (contaId != null) {
			transferencias = transferenciaRepository.findAllByDataTransferenciaBetweenAndContaId(
					inicio, fim, contaId);
		} else if (nomeOperadorTransacao != null) {
			transferencias = transferenciaRepository.findAllByDataTransferenciaBetweenAndNomeOperadorTransacaoIgnoreCase(
					inicio, fim, nomeOperadorTransacao);
		} else {
			transferencias = transferenciaRepository.findAllByDataTransferenciaBetween(inicio, fim);
		}

		return ResponseEntity.ok(transferencias);
	}
}
