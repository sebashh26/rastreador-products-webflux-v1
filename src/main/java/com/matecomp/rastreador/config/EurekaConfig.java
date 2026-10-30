package com.matecomp.rastreador.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class EurekaConfig {

    @Bean
    @LoadBalanced//esta anotacion activa la libreria ribbon al crear dentro del metodo el obj WebClient.builder()
    public WebClient.Builder clientBuilder(){
        return WebClient.builder();
    }
}
