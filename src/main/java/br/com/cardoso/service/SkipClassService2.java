package br.com.cardoso.service;

import br.com.cardoso.annotation.FeatureToggleSkip;
import org.springframework.stereotype.Service;

@Service
@FeatureToggleSkip("skip.class2")
public class SkipClassService2 {

    public void validateClass() {
        System.out.println("Executando método validateClass2");
    }
}
