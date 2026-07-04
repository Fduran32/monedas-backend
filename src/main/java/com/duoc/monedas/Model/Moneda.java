package com.duoc.monedas.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Moneda {

    @Id
    private String codigo;
    private String nombre;
    private Double valor;
    private LocalDateTime ultimaActualizacion;
}