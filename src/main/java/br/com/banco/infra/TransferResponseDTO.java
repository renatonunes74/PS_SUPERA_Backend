package br.com.banco.infra;

import br.com.banco.domain.transfer.Transfer;

public record TransferResponseDTO(Long id, String dataTransferencia, Float valor, String tipo, String nomeOperadorTransacao, Integer contaId) {
	public TransferResponseDTO(Transfer transfer) {
		this(transfer.getId(), transfer.getDataTransferencia(), transfer.getValor(), transfer.getTipo(), transfer.getNomeOperadorTransacao(), transfer.getContaId());
	}
}
