package pe.resource.casadecambio.dto.mapper;

import pe.resource.casadecambio.dto.TransaccionDTO;
import pe.resource.casadecambio.entity.TipoCambio;
import pe.resource.casadecambio.entity.Transaccion;

public class TransaccionMapper {

    public static TransaccionDTO toDTO(Transaccion transaccion) {
        TransaccionDTO dto = new TransaccionDTO();
        dto.setId(transaccion.getId());
        dto.setMonto(transaccion.getMonto());
        dto.setMontoConvertido(transaccion.getMontoConvertido());
        dto.setTipoCambioId(transaccion.getTipoCambio().getId());
        dto.setTipoCambio(TipoCambioMapper.toDto(transaccion.getTipoCambio()));
        return dto;
    }

    public static Transaccion toEntity(TransaccionDTO transaccionDTO) {
        Transaccion transaccion = new Transaccion();
        transaccion.setId(transaccionDTO.getId());
        transaccion.setMonto(transaccionDTO.getMonto());
        transaccion.setMontoConvertido(transaccionDTO.getMontoConvertido());
        return transaccion;
    }
}