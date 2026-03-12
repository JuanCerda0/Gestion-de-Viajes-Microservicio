package app.gestionviajes.service;

import app.gestionviajes.model.Viaje;
import app.gestionviajes.repository.ViajeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ViajeService {

    private final ViajeRepository repository;

    public ViajeService(ViajeRepository repository) {
        this.repository = repository;
    }

    public Viaje crearViaje(Viaje viaje) {
        viaje.setEstado("SOLICITADO");
        viaje.setFechaCreacion(LocalDateTime.now());
        return repository.save(viaje);
    }

    public Viaje obtenerViaje(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Viaje no encontrado"));
    }
}
