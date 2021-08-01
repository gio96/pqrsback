package org.btg.utils;


import org.btg.utils.mapper.ObjectMapper;
import org.reactivecommons.utils.ObjectMapperI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public ObjectMapper beanMapper() {

        return new ObjectMapper() {

            final ObjectMapperI mapper = new ObjectMapperI();

            @Override
            public <T> T map(Object src, Class<T> target) {
                return mapper.map(src, target);
            }

            @Override
            public <T> T mapBuilder(Object src, Class<T> target) {
                return mapper.map(src, target);
            }
        };
    }
}
