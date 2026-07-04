package com.duoc.monedas.Repository;

import com.duoc.monedas.Model.Moneda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonedaRepository  extends JpaRepository<Moneda, String> {
}
