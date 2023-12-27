package br.com.cardoso.service;

import br.com.cardoso.annotation.FeatureToggleSkip;
import org.springframework.stereotype.Service;

@Service
@FeatureToggleSkip("skip.class.3")
public class SkipClassService3 {

    public void validateClass() {
        System.out.println("Executando método validateClass3 - Anotação com valor inesperado");
    }
}
