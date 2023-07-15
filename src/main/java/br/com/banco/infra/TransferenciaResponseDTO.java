package br.com.banco.infra;

import br.com.banco.domain.transferencia.Transferencia;
import java.time.LocalDateTime;

public record TransferenciaResponseDTO(Long id, LocalDateTime dataTransferenciaencia, Float valor, String tipo, String nomeOperadorTransacao, Integer contaId) {
	public TransferenciaResponseDTO(Transferencia transfer) {
		this(transfer.getId(), transfer.getDataTransferencia(), transfer.getValor(), transfer.getTipo(), transfer.getNomeOperadorTransacao(), transfer.getContaId());
	}
}
