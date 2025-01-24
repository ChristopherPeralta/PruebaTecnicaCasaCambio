package pe.resource.casadecambio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoCambioDTO {
    private Long id;
    private Double tasaCambio;
    private MonedaDTO monedaOrigen;
    private MonedaDTO monedaDestino;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTasaCambio() {
        return tasaCambio;
    }

    public void setTasaCambio(Double tasaCambio) {
        this.tasaCambio = tasaCambio;
    }

    public MonedaDTO getMonedaOrigen() {
        return monedaOrigen;
    }

    public void setMonedaOrigen(MonedaDTO monedaOrigen) {
        this.monedaOrigen = monedaOrigen;
    }

    public MonedaDTO getMonedaDestino() {
        return monedaDestino;
    }

    public void setMonedaDestino(MonedaDTO monedaDestino) {
        this.monedaDestino = monedaDestino;
    }
}