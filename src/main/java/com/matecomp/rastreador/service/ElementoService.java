package com.matecomp.rastreador.service;

import com.matecomp.rastreador.model.Elemento;
import reactor.core.publisher.Flux;

public interface ElementoService {
    Flux<Elemento> elementosPrecioMax(double precioMax);
}
