package pe.resource.casadecambio.service;

import pe.resource.casadecambio.dto.MonedaDTO;
import pe.resource.casadecambio.entity.Moneda;

import java.util.List;
import java.util.Optional;

public interface MonedaService {
    List<MonedaDTO> findAll();
    Optional<MonedaDTO> findById(Long id);
    MonedaDTO save(MonedaDTO monedaDTO);
    void deleteById(Long id);
}
