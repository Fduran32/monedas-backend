

package com.duoc.monedas.Controller;

import com.duoc.monedas.Model.Moneda;
import com.duoc.monedas.Service.MonedaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;
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
        List<Moneda> listaMonedas = monedaService.obtenerTodasLasMonedas();

        for (Moneda moneda : listaMonedas) {
            moneda.setUltimaActualizacion(LocalDateTime.now());
        }

        return listaMonedas;
    }
}