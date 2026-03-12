package app.gestionviajes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Viaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long usuarioId;
    private Long conductorId;
    private Long vehiculoId;

    private String origen;
    private String destino;

    private Integer tiempoEstimado;
    private Double costoEstimado;

    private Integer tiempoFinal;
    private Double costoFinal;

    private String estado;

    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;

}
