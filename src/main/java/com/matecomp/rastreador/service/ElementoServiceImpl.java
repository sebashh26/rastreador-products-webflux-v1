package com.matecomp.rastreador.service;

import com.matecomp.rastreador.model.Elemento;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service//para que spring nos instancie esta clase
@RequiredArgsConstructor
public class ElementoServiceImpl implements ElementoService {

    String url1 = "http://servicios-productos1-with-bd";
    String url2 = "http://servicios-productos2-without-bd";

    private final WebClient.Builder  builder;


    @Override
    public Flux<Elemento> elementosPrecioMax(double precioMax) {

        Flux<Elemento>  elementoFlux1 = catalogo(url1, "tienda1");
        Flux<Elemento>  elementoFlux2 = catalogo(url2, "tienda2");

        return Flux.merge(elementoFlux1, elementoFlux2)//Flux<elemnto>
                .filter(elemento -> elemento.getPrecioUnitario() <= precioMax);

    }

    private Flux<Elemento> catalogo(String url, String tienda) {

        WebClient client = builder.build();
        return client
                .get()
                .uri(url + "/productos")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Elemento.class)
                .map(elemento -> {
                    elemento.setTienda(tienda);
                    return elemento;
                });

    }
}
