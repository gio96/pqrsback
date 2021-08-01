package org.btg.config;

import org.btg.gateway.PeticionGateway;
import org.btg.gateway.ReclamoGateway;
import org.btg.usecase.PeticionUseCase;
import org.btg.usecase.ReclamoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public PeticionUseCase peticionUseCase(PeticionGateway peticionGateway) {
        return new PeticionUseCase(peticionGateway);
    }

    @Bean
    public ReclamoUseCase reclamoUseCase(ReclamoGateway reclamoGateway) {
        return new ReclamoUseCase(reclamoGateway);
    }
}
