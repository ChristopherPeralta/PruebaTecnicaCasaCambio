package pe.resource.casadecambio.service;

import pe.resource.casadecambio.dto.TipoCambioDTO;
import pe.resource.casadecambio.entity.TipoCambio;

import java.util.List;
import java.util.Optional;

public interface TipoCambioService {
    List<TipoCambioDTO> findAll();
    Optional<TipoCambioDTO> findById(Long id);
    TipoCambioDTO save(TipoCambioDTO tipoCambioDTO);
    void deleteById(Long id);
    TipoCambioDTO updateTasaCambio(Long id, Double nuevaTasa);


}