package br.com.banco.domain.transfer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;
public interface TransferRepository extends JpaRepository<Transfer, Long> {

	List<Transfer> findAllByContaId(Integer contaId);
	List<Transfer> findAllByNomeOperadorTransacaoContainingIgnoreCase(String nomeOperadorTransacao);
	List<Transfer> findAllByDataTransferenciaBetween(LocalDateTime inicio, LocalDateTime fim);
	List<Transfer> findAllByDataTransferenciaBetweenAndContaId(LocalDateTime inicio, LocalDateTime fim, Integer contaId);
	List<Transfer> findAllByDataTransferenciaBetweenAndNomeOperadorTransacaoIgnoreCase(LocalDateTime inicio, LocalDateTime fim, String nomeOperadorTransacao);
	List<Transfer> findAllByDataTransferenciaBetweenAndContaIdAndNomeOperadorTransacaoIgnoreCase(LocalDateTime inicio, LocalDateTime fim, Integer contaId, String nomeOperadorTransacao);
}
