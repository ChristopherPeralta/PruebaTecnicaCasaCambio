package pe.resource.casadecambio.dto.mapper;

import pe.resource.casadecambio.dto.TipoCambioDTO;
import pe.resource.casadecambio.entity.TipoCambio;

public class TipoCambioMapper {

    public static TipoCambioDTO toDto(TipoCambio tipoCambio) {
        TipoCambioDTO dto = new TipoCambioDTO();
        dto.setId(tipoCambio.getId());
        dto.setTasaCambio(tipoCambio.getTasaCambio());
        dto.setMonedaOrigen(MonedaMapper.toDto(tipoCambio.getMonedaOrigen()));
        dto.setMonedaDestino(MonedaMapper.toDto(tipoCambio.getMonedaDestino()));
        return dto;
    }

    public static TipoCambio toEntity(TipoCambioDTO tipoCambioDTO) {
        TipoCambio tipoCambio = new TipoCambio();
        tipoCambio.setId(tipoCambioDTO.getId());
        tipoCambio.setTasaCambio(tipoCambioDTO.getTasaCambio());
        tipoCambio.setMonedaOrigen(MonedaMapper.toEntity(tipoCambioDTO.getMonedaOrigen()));
        tipoCambio.setMonedaDestino(MonedaMapper.toEntity(tipoCambioDTO.getMonedaDestino()));
        return tipoCambio;
    }
}
