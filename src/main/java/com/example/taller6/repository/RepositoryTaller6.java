package com.example.taller6.repository;

import com.example.taller6.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryTaller6 extends JpaRepository<Producto, String> {

    @Procedure("actualizar_precio_producto")
    void cambiarPrecioProducto(String codigoProducto, int nuevoPrecio);

    @Query( value = "SELECT calcular_factorial(:num) FROM dual", nativeQuery = true)
    int calcularFactorial( int num );

    @Query( value = "SELECT calcular_mcd(:num1, :num2) FROM dual", nativeQuery = true)
    String calcularMCD( int num1, int num2 );

    @Query(value = "SELECT es_primo(:num) FROM dual", nativeQuery = true)
    String validarNumPrimo( int num);

    @Query(value = "SELECT serie_fibonacci(:num) FROM dual", nativeQuery = true)
    String serieFibo( int num);

}
