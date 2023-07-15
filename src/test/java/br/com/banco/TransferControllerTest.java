package br.com.banco;

import br.com.banco.controllers.TransferController;
import br.com.banco.domain.transfer.TransferRepository;
import br.com.banco.infra.TransferResponseDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

@SpringBootTest
public class TransferControllerTest {
    @InjectMocks
    private TransferController transferController;
    @Mock
    private TransferRepository repository;

    // Dados para os testes unitários
    String nomeOperadorTransacao = "Ronnyscley";
    String dataTransacao = "2021-04-01 12:12:04+03";
    LocalDate inicio = LocalDate.parse("2019-04-01");
    LocalDate fim = LocalDate.parse("2021-04-01");
    Integer contaId = 1;

    void getAll() {
        var response = Assertions.assertDoesNotThrow(() -> transferController.getAll());
        Assertions.assertEquals(transferController.getAll(), response);
    }
    @Test // Teste pelo ID da conta
    void getAllByContaId() {
        var response = Assertions.assertDoesNotThrow(() -> transferController.getAllByContaId(contaId));
        Assertions.assertEquals(transferController.getAllByContaId(contaId), response);
    }
    @Test // Teste pelo nome do operador de transação
    void getAllByNomeOperadorTransacao() {
        var response = Assertions.assertDoesNotThrow(() -> transferController.getAllByNomeOperadorTransacao(nomeOperadorTransacao));
        Assertions.assertEquals(transferController.getAllByNomeOperadorTransacao(nomeOperadorTransacao), response);
    }

    @Test // Teste pelos filtros de período
    void getAllWithFilterPeriod() {
        var response = Assertions.assertDoesNotThrow(() -> transferController.getAllWithFilter(inicio, fim, null, null));
        Assertions.assertEquals(transferController.getAllWithFilter(inicio, fim, null, null), response);
    }

    @Test // Teste pelos filtros de período e operador
    void getAllWithFilterPeriodAndOperador() {
        var response = Assertions.assertDoesNotThrow(() -> transferController.getAllWithFilter(inicio, fim, null, nomeOperadorTransacao));
        Assertions.assertEquals(transferController.getAllWithFilter(inicio, fim, null, nomeOperadorTransacao), response);
    }

    @Test // Teste pelos filtros de período e conta
    void getAllWithFilterPeriodAndNomeOperadorTransacao() {
        var response = Assertions.assertDoesNotThrow(() -> transferController.getAllWithFilter(inicio, fim, contaId, null));
        Assertions.assertEquals(transferController.getAllWithFilter(inicio, fim, contaId, null), response);
    }
    @Test // Teste por todos os filtros
    void getAllWithFilter() {
        var response = Assertions.assertDoesNotThrow(() -> transferController.getAllWithFilter(inicio, fim, contaId, nomeOperadorTransacao));
        Assertions.assertEquals(transferController.getAllWithFilter(inicio, fim, contaId, nomeOperadorTransacao), response);
    }
}