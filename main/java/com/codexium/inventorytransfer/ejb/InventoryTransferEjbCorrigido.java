package inventorytransfer.ejb;


import inventorytransfer.model.Stock;
import inventorytransfer.repository.StockRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryTransferEjbCorrigido {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private StockRepository stockRepository;

    @Transactional
    public void transferir(Long origemId, Long destinoId, int quantidade){
        Stock origem = em.find(Stock.class, origemId);
        Stock destino = em.find(Stock.class, destinoId);

        if (origem == null || destino == null) {
            throw new IllegalArgumentException("Estoque não encontrado...");
        }

        if (origem.getQuantity()< quantidade){
            throw new IllegalArgumentException("Estoque insuficiente para transferência...");
        }

        origem.setQuantity(origem.getQuantity() - quantidade);
        destino.setQuantity((destino.getQuantity() + quantidade));

        em.merge(origem);
        em.merge(destino);

    }




}
