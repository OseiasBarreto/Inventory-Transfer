package inventorytransfer.repository;

import inventorytransfer.model.Product;
import inventorytransfer.model.Stock;
import inventorytransfer.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, Long> {
    Optional<Stock> findByWarehouseAndProduct(Warehouse warehouse, Product product);
}
