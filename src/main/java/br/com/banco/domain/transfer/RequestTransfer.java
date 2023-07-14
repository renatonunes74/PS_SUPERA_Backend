package br.com.banco.domain.transfer;

public record RequestTransfer(
	Long id,
	String dataTransferencia,
	Float valor,
	String tipo,
	String nomeOperadorTransacao,
	Integer contaId
) {
}

