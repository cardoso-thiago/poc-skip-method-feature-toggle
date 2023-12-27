package br.com.cardoso.service;

import br.com.cardoso.annotation.FeatureToggleSkip;
import org.springframework.stereotype.Service;

@Service
public class SkipService {

    @FeatureToggleSkip("skip.method.one")
    public void validateOne() {
        System.out.println("Executando método validateOne");
    }

    @FeatureToggleSkip("skip.method.two")
    public void validateTwo() {
        System.out.println("Executando método validateTwo");
    }

    public void validateThree() {
        System.out.println("Executando método validateThree - Sem anotação");
    }
}
