package com.example.taller6.controller;


import com.example.taller6.repository.RepositoryTaller6;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class Controller {

   @Autowired
    private RepositoryTaller6 repository;



    @GetMapping("/factorial/{numero}")
    public int calcFactorial( @PathVariable int numero ){
        return repository.calcularFactorial( numero );
    }

    @GetMapping("/mcd/{numero1}/{numero2}")
    public String calcMcd( @PathVariable int numero1, @PathVariable int numero2 ){ return repository.calcularMCD( numero1, numero2 );  }

    @GetMapping("/primo/{numero}")
    public String numPrimo( @PathVariable int numero ){
        return repository.validarNumPrimo(numero);
    }

    @GetMapping("/fibonacci/{numero}")
    public String fibo( @PathVariable int numero ){
        return repository.serieFibo(numero);
    }


    @PatchMapping("/cambiarPrecio")
    public void cambiarPrecio(@RequestBody Map<String, Object> cambios) {
        try {

            String codigoProducto = (String) cambios.get("codProducto");
            int nuevoPrecio = (int) cambios.get("precioUnitario");

            repository.cambiarPrecioProducto(codigoProducto, nuevoPrecio);

        } catch (Exception e) {
            System.out.println( e.toString() );
        }
    }

}

