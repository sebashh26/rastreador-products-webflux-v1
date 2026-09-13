package com.matecomp.rastreador.controller;

import com.matecomp.rastreador.model.Elemento;
import com.matecomp.rastreador.service.ElementoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class ElementosController {

    @Autowired
    ElementoService  elementoService;

    @GetMapping(value = "elementos/{precio}")
    public ResponseEntity<Flux<Elemento>> listarElementosByPrecio(@PathVariable("precio") double precioMax){
        return  new ResponseEntity<>(elementoService.elementosPrecioMax(precioMax), HttpStatus.OK);
    }
}
