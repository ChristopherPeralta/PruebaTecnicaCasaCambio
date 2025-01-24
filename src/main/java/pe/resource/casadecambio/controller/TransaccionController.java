package pe.resource.casadecambio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.resource.casadecambio.dto.TransaccionDTO;
import pe.resource.casadecambio.entity.Transaccion;
import pe.resource.casadecambio.exception.ResourceNotFoundException;
import pe.resource.casadecambio.service.TransaccionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transacciones")
public class TransaccionController {

    @Autowired
    private TransaccionService service;

    @GetMapping
    public List<TransaccionDTO> getAllTransacciones() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransaccionDTO> getTransaccionById(@PathVariable Long id) {
        TransaccionDTO transaccionDTO = service.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaccion not found for this id :: " + id));
        return ResponseEntity.ok().body(transaccionDTO);
    }

    @PostMapping
    public TransaccionDTO createTransaccion(@RequestBody TransaccionDTO transaccionDTO) {
        return service.save(transaccionDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransaccionDTO> updateTransaccion(@PathVariable Long id, @RequestBody TransaccionDTO transaccionDetails) {
        TransaccionDTO transaccionDTO = service.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaccion not found for this id :: " + id));
        transaccionDTO.setMonto(transaccionDetails.getMonto());
        transaccionDTO.setMontoConvertido(transaccionDetails.getMontoConvertido());
        transaccionDTO.setTipoCambioId(transaccionDetails.getTipoCambioId());
        return ResponseEntity.ok(service.save(transaccionDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaccion(@PathVariable Long id) {
        TransaccionDTO transaccionDTO = service.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaccion not found for this id :: " + id));
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
