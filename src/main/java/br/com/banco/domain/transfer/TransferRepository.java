package br.com.banco.domain.transfer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;
public interface TransferRepository extends JpaRepository<Transfer, Long> {
	List<Transfer> findAllByNomeOperadorTransacaoContainingIgnoreCase(String nomeOperadorTransacao);
	List<Transfer> findAllByDataTransferenciaContainingIgnoreCase(String dataTransferencia);
	List<Transfer> findAllByNomeOperadorTransacaoAndDataTransferenciaContainingIgnoreCase(
		String  nomeOperadorTransacao,
		String dataTransferencia);
}
