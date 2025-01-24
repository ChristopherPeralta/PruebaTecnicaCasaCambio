package pe.resource.casadecambio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.resource.casadecambio.dto.MonedaDTO;
import pe.resource.casadecambio.entity.Moneda;
import pe.resource.casadecambio.exception.ResourceNotFoundException;
import pe.resource.casadecambio.service.MonedaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/moneda")
public class MonedaController {

    @Autowired
    private MonedaService service;

    @GetMapping
    public List<MonedaDTO> getAllMonedas() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MonedaDTO> getMonedaById(@PathVariable Long id) {
        MonedaDTO moneda = service.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Moneda not found for this id :: " + id));
        return ResponseEntity.ok().body(moneda);
    }

    @PostMapping
    public MonedaDTO createMoneda(@RequestBody MonedaDTO monedaDTO) {
        return service.save(monedaDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MonedaDTO> updateMoneda(@PathVariable Long id, @RequestBody MonedaDTO monedaDetails) {
        MonedaDTO moneda = service.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Moneda not found for this id :: " + id));
        moneda.setCodigo(monedaDetails.getCodigo());
        moneda.setNombre(monedaDetails.getNombre());
        return ResponseEntity.ok(service.save(moneda));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMoneda(@PathVariable Long id) {
        MonedaDTO moneda = service.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Moneda not found for this id :: " + id));
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
