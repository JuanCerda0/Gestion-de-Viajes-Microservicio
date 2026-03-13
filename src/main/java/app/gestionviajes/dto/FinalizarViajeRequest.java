package app.gestionviajes.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FinalizarViajeRequest {

    private Double costoFinal;
    private Integer tiempoFinal;
}
