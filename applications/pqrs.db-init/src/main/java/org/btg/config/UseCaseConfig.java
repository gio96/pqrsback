package org.btg.config;

import org.btg.gateway.PqrGateway;
import org.btg.gateway.ReclamoGateway;
import org.btg.usecase.PqrUseCase;
import org.btg.usecase.ReclamoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public PqrUseCase peticionUseCase(PqrGateway pqrGateway) {
        return new PqrUseCase(pqrGateway);
    }

    @Bean
    public ReclamoUseCase reclamoUseCase(ReclamoGateway reclamoGateway) {
        return new ReclamoUseCase(reclamoGateway);
    }
}
