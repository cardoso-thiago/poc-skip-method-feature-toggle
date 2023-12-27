package br.com.cardoso.configuration;

import br.com.cardoso.aspect.SkipAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class FeatureToggleSkipConfiguration {

    @Bean
    public SkipAspect skipAspect(Environment environment) {
        return new SkipAspect(environment);
    }
}
