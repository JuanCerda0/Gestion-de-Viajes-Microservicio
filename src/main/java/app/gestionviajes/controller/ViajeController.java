package app.gestionviajes.controller;

import app.gestionviajes.dto.FinalizarViajeRequest;
import app.gestionviajes.model.Viaje;
import app.gestionviajes.service.ViajeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/viajes")
public class ViajeController {

    private final ViajeService service;

    public ViajeController(ViajeService service) {
        this.service = service;
    }

    @PostMapping
    public Viaje crear(@RequestBody Viaje viaje) {
        return service.crearViaje(viaje);
    }

    @GetMapping("/{id}")
    public Viaje obtener(@PathVariable Long id) {
        return service.obtenerViaje(id);
    }

    @GetMapping
    public List<Viaje> listar() {
        return service.listarViajes();
    }

    @PutMapping("/{id}/iniciar")
    public Viaje iniciar(@PathVariable Long id) {
        return service.iniciarViaje(id);
    }

    @PutMapping("/{id}/finalizar")
    public Viaje finalizar(@PathVariable Long id, @RequestBody FinalizarViajeRequest request) {
        return service.finalizarViaje(id, request.getCostoFinal(), request.getTiempoFinal());
    }

    @PutMapping("/{id}/cancelar")
    public Viaje cancelar(@PathVariable Long id) {
        return service.cancelarViaje(id);
    }
}
