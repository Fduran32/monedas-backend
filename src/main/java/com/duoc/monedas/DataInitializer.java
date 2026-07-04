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
        // Simulamos lo que la AWS Lambda insertará en el futuro
        monedaRepository.save(new Moneda("USD", "Dólar Estadounidense", 945.50, LocalDateTime.now()));
        monedaRepository.save(new Moneda("EUR", "Euro", 1020.15, LocalDateTime.now()));
        System.out.println("¡Datos iniciales de monedas insertados en la BD H2!");
    }
}