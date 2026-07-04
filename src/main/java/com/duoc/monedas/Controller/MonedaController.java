package com.duoc.monedas.Controller;

import com.duoc.monedas.Model.Moneda;
import com.duoc.monedas.Service.MonedaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime; // <--- 1. ASEGÚRATE DE AGREGAR ESTA IMPORTACIÓN
import java.util.List;

@RestController
@RequestMapping("/api")
public class MonedaController {

    private final MonedaService monedaService;

    public MonedaController(MonedaService monedaService) {
        this.monedaService = monedaService;
    }

    @GetMapping("/valores")
    public List<Moneda> getValoresReales() {
        // 2. Traemos la lista original del servicio
        List<Moneda> listaMonedas = monedaService.obtenerTodasLasMonedas();

        // 3. Le asignamos la hora exacta de ESTE milisegundo a cada moneda
        for (Moneda moneda : listaMonedas) {
            moneda.setUltimaActualizacion(LocalDateTime.now());
        }

        // 4. Retornamos la lista con las horas frescas
        return listaMonedas;
    }
}