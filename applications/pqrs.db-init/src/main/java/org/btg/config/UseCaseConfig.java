package org.btg.config;

import org.btg.gateway.SolicitudGateway;
import org.btg.gateway.ReclamoGateway;
import org.btg.usecase.SolicitudUseCase;
import org.btg.usecase.ReclamoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public SolicitudUseCase peticionUseCase(SolicitudGateway solicitudGateway) {
        return new SolicitudUseCase(solicitudGateway);
    }

    @Bean
    public ReclamoUseCase reclamoUseCase(ReclamoGateway reclamoGateway) {
        return new ReclamoUseCase(reclamoGateway);
    }
}
