package inventorytransfer.ejb;


import inventorytransfer.model.Stock;
import inventorytransfer.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class InventoryTransferEjbBugado {

    @Autowired
    private StockRepository stockRepository;

    public void transferir (Long origemId, Long destinoId, int quantidade) {
        Stock origem = stockRepository.findById(origemId).orElse(null);
        Stock destino = stockRepository.findById(destinoId).orElse(null);

        //aq ele nao faz vericação e tb nao tem o rollback
        origem.setQuantity(origem.getQuantity() - quantidade);
        destino.setQuantity(destino.getQuantity() + quantidade);

        stockRepository.save(origem);
        stockRepository.save(destino);
    }


}
