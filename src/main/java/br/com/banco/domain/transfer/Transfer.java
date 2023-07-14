package br.com.banco.domain.transfer;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "transferencia")
@Entity(name = "transferencia")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Transfer {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String dataTransferencia;
	private Float valor;
	private String tipo;
	private String nomeOperadorTransacao;
	private Integer contaId;
	public Transfer(RequestTransfer data){
		this.dataTransferencia = data.dataTransferencia();
		this.valor = data.valor();
		this.tipo = data.tipo();
		this.nomeOperadorTransacao = data.nomeOperadorTransacao();
		this.contaId = data.contaId();
	}
}
