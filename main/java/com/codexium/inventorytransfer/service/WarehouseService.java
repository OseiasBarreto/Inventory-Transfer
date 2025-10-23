package inventorytransfer.service;

import inventorytransfer.model.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import inventorytransfer.repository.WarehouseRepository;

import java.util.List;

@Service
public class WarehouseService {

    @Autowired
    private WarehouseRepository repository;

    public List<Warehouse> findAll(){
        return repository.findAll();
    }
    public Warehouse findById(Long id) {
        return repository.findById(id).orElse(null);
    }
    public Warehouse save(Warehouse warehouse){
        return repository.save(warehouse);
    }
    public void delete(Long id){
        repository.deleteById(id);
    }
}
