package inventorytransfer.service;


import inventorytransfer.model.Product;
import inventorytransfer.model.Stock;
import inventorytransfer.model.Warehouse;
import inventorytransfer.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockService {

    @Autowired
    private StockRepository repository;

    public List<Stock> findAll(){
        return repository.findAll();
    }
    public Stock findById(Long id){
        return repository.findById(id).orElse(null);
        }
        public Stock save(Stock stock){
        return repository.save(stock);
        }
        public void delete(Long id){
        repository.deleteById(id);
        }
        public Optional<Stock> findByWarehouseAndProduct(Warehouse warehouse, Product product){
            return repository.findByWarehouseAndProduct(warehouse, product);
        }
    }

