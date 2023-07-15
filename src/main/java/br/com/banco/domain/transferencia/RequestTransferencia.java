package br.com.banco.domain.transferencia;

import java.time.LocalDateTime;

public record RequestTransferencia(
	Long id,
	LocalDateTime dataTransferencia,
	Float valor,
	String tipo,
	String nomeOperadorTransacao,
	Integer contaId
) {
}

