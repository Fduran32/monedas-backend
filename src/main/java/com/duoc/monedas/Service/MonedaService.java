package com.duoc.monedas.Service;

import com.duoc.monedas.Model.Moneda;
import com.duoc.monedas.Repository.MonedaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service // Le dice a Spring que esta clase contiene la lógica de negocio
public class MonedaService {

    private final MonedaRepository monedaRepository;

    // Inyectamos el repositorio al servicio
    public MonedaService(MonedaRepository monedaRepository) {
        this.monedaRepository = monedaRepository;
    }

    // Aquí defines tus métodos de negocio
    public List<Moneda> obtenerTodasLasMonedas() {
        // En el futuro, aquí podrías aplicar filtros, lógica de conversión, etc.
        return monedaRepository.findAll();
    }
}