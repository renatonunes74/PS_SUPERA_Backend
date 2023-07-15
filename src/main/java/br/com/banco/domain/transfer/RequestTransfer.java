package br.com.banco.domain.transfer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

public record RequestTransfer(
	Long id,
	LocalDateTime dataTransferencia,
	Float valor,
	String tipo,
	String nomeOperadorTransacao,
	Integer contaId
) {
}

