package pe.resource.casadecambio.service;

import pe.resource.casadecambio.dto.TransaccionDTO;
import pe.resource.casadecambio.entity.Transaccion;

import java.util.List;
import java.util.Optional;

public interface TransaccionService {
    List<TransaccionDTO> findAll();
    Optional<TransaccionDTO> findById(Long id);
    TransaccionDTO save(TransaccionDTO transaccionDTO);
    void deleteById(Long id);
}