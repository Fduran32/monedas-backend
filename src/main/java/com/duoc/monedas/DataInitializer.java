package com.duoc.monedas;

import com.duoc.monedas.Model.Moneda;
import com.duoc.monedas.Repository.MonedaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class DataInitializer implements CommandLineRunner {

    private final MonedaRepository monedaRepository;

    public DataInitializer(MonedaRepository monedaRepository) {
        this.monedaRepository = monedaRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Indicadores económicos clave para Chile
        monedaRepository.save(new Moneda("USD", "Dólar Estadounidense", 945.50, LocalDateTime.now()));
        monedaRepository.save(new Moneda("EUR", "Euro", 1020.15, LocalDateTime.now()));
        monedaRepository.save(new Moneda("UF", "Unidad de Fomento", 37950.40, LocalDateTime.now()));
        monedaRepository.save(new Moneda("UTM", "Unidad Tributaria Mensual", 66200.00, LocalDateTime.now()));
        monedaRepository.save(new Moneda("ARS", "Peso Argentino", 1.05, LocalDateTime.now()));
        monedaRepository.save(new Moneda("BRL", "Real Brasileño", 172.30, LocalDateTime.now()));
        monedaRepository.save(new Moneda("COBRE", "Libra de Cobre (USD)", 4.15, LocalDateTime.now()));

        System.out.println("¡Datos iniciales de monedas insertados en la BD H2!");
    }
}