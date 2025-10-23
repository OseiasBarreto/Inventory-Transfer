/*package inventorytransfer.inventorytransferTest;

import inventorytransfer.ejb.InventoryTransferEjbCorrigido;
import inventorytransfer.model.Stock;
import inventorytransfer.repository.StockRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.testng.Assert.assertThrows;

@SpringBootTest
public class TransferServiceTest {

    private InventoryTransferEjbCorrigido service;
    private StockRepository repository;

    @BeforeEach
    void setup() {
        repository = mock(StockRepository.class);
        service = new InventoryTransferEjbCorrigido();
    }

    @Test
    void deveTransferirComSucesso() {
        Stock origem = new Stock();
        origem.setId(1L);
        origem.setQuantity(10);

        Stock destino = new Stock();
        destino.setId(2L);
        destino.setQuantity(5);

        // Mockando entity manager com comportamento simulado
        service = Mockito.spy(service);
        doReturn(origem).when(service).findStockById(1L);
        doReturn(destino).when(service).findStockById(2L);

        service.transferir(1L, 2L, 3);

        assertEquals(7, origem.getQuantity());
        assertEquals(8, destino.getQuantity());
    }

    @Test
    void deveLancarErroQuandoEstoqueInsuficiente() {
        Stock origem = new Stock();
        origem.setId(1L);
        origem.setQuantity(2);

        Stock destino = new Stock();
        destino.setId(2L);
        destino.setQuantity(5);

        service = Mockito.spy(service);
        doReturn(origem).when(service).findStockById(1L);
        doReturn(destino).when(service).findStockById(2L);

        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            service.transferir(1L, 2L, 10);
        });

        assertTrue(e.getMessage().contains("Estoque insuficiente"));
    }
}
*/