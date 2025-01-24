package pe.resource.casadecambio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.resource.casadecambio.dto.TipoCambioDTO;
import pe.resource.casadecambio.entity.TipoCambio;
import pe.resource.casadecambio.exception.ResourceNotFoundException;
import pe.resource.casadecambio.service.TipoCambioService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tipo-cambio")
public class TipoCambioController {

    @Autowired
    private TipoCambioService service;

    @GetMapping
    public List<TipoCambioDTO> getAllTiposCambio() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoCambioDTO> getTipoCambioById(@PathVariable Long id) {
        TipoCambioDTO tipoCambio = service.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tipo de cambio not found for this id :: " + id));
        return ResponseEntity.ok().body(tipoCambio);
    }

    @PostMapping
    public TipoCambioDTO createTipoCambio(@RequestBody TipoCambioDTO tipoCambioDTO) {
        return service.save(tipoCambioDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoCambioDTO> updateTipoCambio(@PathVariable Long id, @RequestBody TipoCambioDTO tipoCambioDetails) {
        TipoCambioDTO tipoCambio = service.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tipo de cambio not found for this id :: " + id));
        tipoCambio.setTasaCambio(tipoCambioDetails.getTasaCambio());
        tipoCambio.setMonedaOrigen(tipoCambioDetails.getMonedaOrigen());
        tipoCambio.setMonedaDestino(tipoCambioDetails.getMonedaDestino());
        return ResponseEntity.ok(service.save(tipoCambio));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoCambio(@PathVariable Long id) {
        TipoCambioDTO tipoCambio = service.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tipo de cambio not found for this id :: " + id));
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/tasa")
    public ResponseEntity<TipoCambioDTO> updateTasaCambio(@PathVariable Long id, @RequestBody Double nuevaTasa) {
        TipoCambioDTO updatedTipoCambio = service.updateTasaCambio(id, nuevaTasa);
        return ResponseEntity.ok(updatedTipoCambio);
    }
}