package br.com.cardoso.service;

import br.com.cardoso.annotation.FeatureToggleSkip;
import org.springframework.stereotype.Service;

@Service
@FeatureToggleSkip("skip.class")
public class SkipClassService {

    public void validateClass() {
        System.out.println("Executando método validateClass");
    }
}
