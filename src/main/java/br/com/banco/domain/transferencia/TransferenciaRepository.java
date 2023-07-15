package br.com.banco.domain.transferencia;

import jakarta.persistence.Index;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {

	List<Transferencia> findAllByContaId(Integer contaId);
	List<Transferencia> findAllByNomeOperadorTransacaoContainingIgnoreCase(String nomeOperadorTransacao);
	List<Transferencia> findAllByDataTransferenciaBetween(LocalDateTime inicio, LocalDateTime fim);
	List<Transferencia> findAllByDataTransferenciaBetweenAndContaId(LocalDateTime inicio, LocalDateTime fim, Integer contaId);
	List<Transferencia> findAllByDataTransferenciaBetweenAndNomeOperadorTransacaoIgnoreCase(LocalDateTime inicio, LocalDateTime fim, String nomeOperadorTransacao);
	List<Transferencia> findAllByDataTransferenciaBetweenAndContaIdAndNomeOperadorTransacaoIgnoreCase(LocalDateTime inicio, LocalDateTime fim, Integer contaId, String nomeOperadorTransacao);
}
