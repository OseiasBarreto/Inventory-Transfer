package inventorytransfer.controller;

import inventorytransfer.model.Product;
import inventorytransfer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {


    @Autowired
    private ProductService service;

    @GetMapping
    public List<Product> listar(){
        return service.findAll();
    }
    @GetMapping("/{id}")
    public Product buscar (@PathVariable Long id){
        return service.findById(id);
    }
    @PostMapping
    public Product criar(@RequestBody Product product){
        return service.save(product);
    }

    @PutMapping
    public Product atualizar(@PathVariable Long id, @RequestBody Product product){
        Product existente = service.findById(id);
        if (existente == null) return null;
        existente.setName(product.getName());
        existente.setDescription(product.getDescription());
        return service.save(existente);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        service.delete(id);
    }
}


