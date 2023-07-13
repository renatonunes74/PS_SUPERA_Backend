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

@SpringBootTest
public class TransferControllerTest {
    @InjectMocks
    private TransferController transferController;
    @Mock
    private TransferRepository repository;

    // Dados para os testes unitários
    String nome = "Ronnyscley";
    String data = "2021-04-01 12:12:04+03";

    @Test // Teste pelo nome do operador
    void getAllByNomeOperadorTransacao() {
        var response = Assertions.assertDoesNotThrow(() -> transferController.getAllByNomeOperadorTransacao(nome));
        Assertions.assertEquals(transferController.getAllByNomeOperadorTransacao(nome), response);
    }
    @Test // Teste pela data do operador
    void getAllByDataTransferencia() {
        var response = Assertions.assertDoesNotThrow(() -> transferController.getAllByDataTransferencia(data));
        Assertions.assertEquals(transferController.getAllByDataTransferencia(data), response);
    }
    @Test // Teste pela data do operador e nome
    void getAllByNomeOperadorAndDataTransferencia() {
        var response = Assertions.assertDoesNotThrow(() -> transferController.getAllByNomeOperadorAndDataTransferencia(data, nome));
        Assertions.assertEquals(transferController.getAllByNomeOperadorAndDataTransferencia(data, nome), response);
    }
}