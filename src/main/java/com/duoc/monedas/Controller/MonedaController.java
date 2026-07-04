package com.duoc.monedas.controller;

import com.duoc.monedas.Model.Moneda;
import com.duoc.monedas.Service.MonedaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MonedaController {

    private final MonedaService monedaService;

    // Ahora inyectamos el SERVICIO
    public MonedaController(MonedaService monedaService) {
        this.monedaService = monedaService;
    }

    @GetMapping("/valores")
    public List<Moneda> getValoresReales() {
        // El controlador le pide los datos al servicio
        return monedaService.obtenerTodasLasMonedas();
    }
}