package br.com.cardoso.controller;

import br.com.cardoso.service.SkipClassService;
import br.com.cardoso.service.SkipClassService2;
import br.com.cardoso.service.SkipClassService3;
import br.com.cardoso.service.SkipService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final SkipService skipService;
    private final SkipClassService skipClassService;
    private final SkipClassService2 skipClassService2;
    private final SkipClassService3 skipClassService3;

    public TestController(SkipService skipService, SkipClassService skipClassService, SkipClassService2 skipClassService2, SkipClassService3 skipClassService3) {
        this.skipService = skipService;
        this.skipClassService = skipClassService;
        this.skipClassService2 = skipClassService2;
        this.skipClassService3 = skipClassService3;
    }

    @GetMapping("/test")
    public String test() {
        skipService.validateOne();
        skipService.validateTwo();
        skipService.validateThree();
        skipClassService.validateClass();
        skipClassService2.validateClass();
        skipClassService3.validateClass();
        return "ok";
    }
}
