package inventorytransfer.controller;

import inventorytransfer.model.Stock;
import inventorytransfer.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    @Autowired
    private StockService service;

    @GetMapping
    public List<Stock> listar(){
        return service.findAll();
    }
    @GetMapping("/{id}")
    public Stock buscar(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping
    public Stock criar(@RequestBody Stock stock){
        return service.save(stock);
    }

    @PutMapping("/{id}")
        public Stock atualizar(@PathVariable Long id, @RequestBody Stock stock){
            Stock existente = service.findById(id);
            if (existente == null) return null;
            existente.setWarehouse(stock.getWarehouse());
            existente.setProduct(stock.getProduct());
            existente.setQuantity(stock.getQuantity());
            return service.save(existente);
        }
        @DeleteMapping("/{id}")
        public void deletar (@PathVariable Long id){
        service.delete(id);
    }
}
