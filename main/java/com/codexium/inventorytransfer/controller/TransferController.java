package inventorytransfer.controller;

import inventorytransfer.ejb.InventoryTransferEjbCorrigido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/transfer")
public class TransferController {

    @Autowired
    private InventoryTransferEjbCorrigido transferService;

    @PostMapping
    public ResponseEntity<?> transferir(@RequestParam Long origemId,
                                        @RequestParam Long destinoId,
                                        @RequestParam int quantidade) {
        try {
            transferService.transferir(origemId, destinoId, quantidade);
            return ResponseEntity.ok("Transferência concluída com sucesso!");

        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erro: " + e.getMessage());

        } catch (OptimisticLockingFailureException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Conflito de atualização: outro processo modificou o estoque.");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro inesperado: " + e.getMessage());
        }
    }
}
