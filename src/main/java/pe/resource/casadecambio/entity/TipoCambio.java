package pe.resource.casadecambio.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoCambio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double tasaCambio;

    @ManyToOne
    private Moneda monedaOrigen;

    @ManyToOne
    private Moneda monedaDestino;

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

    public Moneda getMonedaOrigen() {
        return monedaOrigen;
    }

    public void setMonedaOrigen(Moneda monedaOrigen) {
        this.monedaOrigen = monedaOrigen;
    }

    public Moneda getMonedaDestino() {
        return monedaDestino;
    }

    public void setMonedaDestino(Moneda monedaDestino) {
        this.monedaDestino = monedaDestino;
    }
}