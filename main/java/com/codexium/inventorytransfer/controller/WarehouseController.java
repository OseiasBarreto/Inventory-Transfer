package inventorytransfer.controller;

import inventorytransfer.model.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import inventorytransfer.service.WarehouseService;

import java.util.List;


@RestController
@RequestMapping("/api/warehouses")
public class WarehouseController {

    @Autowired
    private WarehouseService service;

    @GetMapping
    public List<Warehouse> listar(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Warehouse buscarPorId(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping
    public Warehouse criar(@RequestBody Warehouse warehouse){
        return service.save(warehouse);
    }
    @PutMapping
    public Warehouse atualizar(@PathVariable Long id, @RequestBody Warehouse warehouse) {
        Warehouse existente = service.findById(id);
        if (existente == null) return null;
        existente.setName(warehouse.getName());
        existente.setName(warehouse.getLocation());
        return service.save(existente);
    }

    @DeleteMapping
    public void deletar(@PathVariable Long id) {
        service.delete(id);
    }

}


