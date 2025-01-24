package pe.resource.casadecambio.dto.mapper;

import pe.resource.casadecambio.dto.MonedaDTO;
import pe.resource.casadecambio.entity.Moneda;

public class MonedaMapper {
/*NO FUNCIONA BUILDER
    public static MonedaDTO toDto(Moneda moneda) {
        return MonedaDTO.builder()
                .id(moneda.getId())
                .codigo(moneda.getCodigo())
                .nombre(moneda.getNombre())
                .build();
    }

 */

    public static MonedaDTO toDto(Moneda moneda) {
        MonedaDTO dto = new MonedaDTO();
        dto.setId(moneda.getId());
        dto.setCodigo(moneda.getCodigo());
        dto.setNombre(moneda.getNombre());
        return dto;
    }
/*
    public static Moneda toEntity(MonedaDTO monedaDTO) {
        return Moneda.builder()
                .id(monedaDTO.getId())
                .codigo(monedaDTO.getCodigo())
                .nombre(monedaDTO.getNombre())
                .build();
    }

 */
public static Moneda toEntity(MonedaDTO monedaDTO) {
    Moneda moneda = new Moneda();
    moneda.setId(monedaDTO.getId());
    moneda.setCodigo(monedaDTO.getCodigo());
    moneda.setNombre(monedaDTO.getNombre());
    return moneda;
}
}