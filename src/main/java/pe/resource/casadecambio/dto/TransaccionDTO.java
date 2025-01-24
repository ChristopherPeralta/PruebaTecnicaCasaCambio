package pe.resource.casadecambio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransaccionDTO {
    private Long id;
    private Double monto;
    private Double montoConvertido;
    private Long tipoCambioId;
    private TipoCambioDTO tipoCambio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Double getMontoConvertido() {
        return montoConvertido;
    }

    public void setMontoConvertido(Double montoConvertido) {
        this.montoConvertido = montoConvertido;
    }

    public Long getTipoCambioId() {
        return tipoCambioId;
    }

    public void setTipoCambioId(Long tipoCambioId) {
        this.tipoCambioId = tipoCambioId;
    }

    public TipoCambioDTO getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(TipoCambioDTO tipoCambio) {
        this.tipoCambio = tipoCambio;
    }
}
