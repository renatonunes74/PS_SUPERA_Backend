package br.com.banco.domain.transferencia;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "transferencia")
@Entity(name = "transferencia")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Transferencia {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime dataTransferencia;
	private Float valor;
	private String tipo;
	private String nomeOperadorTransacao;
	private Integer contaId;
	public Transferencia(RequestTransferencia data){
		this.dataTransferencia = data.dataTransferencia();
		this.valor = data.valor();
		this.tipo = data.tipo();
		this.nomeOperadorTransacao = data.nomeOperadorTransacao();
		this.contaId = data.contaId();
	}
}
