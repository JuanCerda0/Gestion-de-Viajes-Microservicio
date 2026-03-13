package app.gestionviajes.service;

import app.gestionviajes.model.Viaje;
import app.gestionviajes.repository.ViajeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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

    public List<Viaje> listarViajes() {
        return repository.findAll();
    }

    public Viaje iniciarViaje(Long id) {
        Viaje viaje = obtenerViaje(id);
        viaje.setEstado("EN_CURSO");
        
        viaje.setFechaInicio(LocalDateTime.now());
        
        return repository.save(viaje);
    }
    
    public Viaje finalizarViaje(Long id, Double costoFinal, Integer tiempoFinal) {
        
        Viaje viaje = obtenerViaje(id); 
        viaje.setEstado("FINALIZADO");
        
        viaje.setFechaFin(LocalDateTime.now());
        viaje.setCostoFinal(costoFinal);
        viaje.setTiempoFinal(tiempoFinal);
        
        return repository.save(viaje);
    }

    public Viaje cancelarViaje(Long id) {
       
        Viaje viaje = obtenerViaje(id);
        viaje.setEstado("CANCELADO");
        
        return repository.save(viaje);
    }
    
    
}
