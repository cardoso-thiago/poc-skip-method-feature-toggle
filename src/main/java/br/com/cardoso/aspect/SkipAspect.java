package br.com.cardoso.aspect;

import br.com.cardoso.annotation.FeatureToggleSkip;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.env.Environment;

@Aspect
public class SkipAspect {

    private final Environment environment;

    public SkipAspect(Environment environment) {
        this.environment = environment;
    }

    //Abordagem que funciona somente para métodos, mas que não usa reflection
//    @Pointcut(value="@annotation(featureToggleSkip)",argNames="featureToggleSkip")
//    public void featureTogglePointcut(FeatureToggleSkip featureToggleSkip) {
//    }
//
//    @Around("featureTogglePointcut(featureToggleSkip)")
//    public Object featureToggleSkip(ProceedingJoinPoint joinPoint, FeatureToggleSkip featureToggleSkip) throws Throwable {
//        String skip = environment.getProperty(featureToggleSkip.value());
//        if (Boolean.parseBoolean(skip)) {
//            return false;
//        }
//        return joinPoint.proceed();
//    }

    //Abordagem que funciona para métodos e classes, mas que usa reflection através do AnnotationUtils
    @Pointcut("@within(featureToggleSkip) || @annotation(featureToggleSkip)")
    public void featureTogglePointcut(FeatureToggleSkip featureToggleSkip) {
    }
    @Around("featureTogglePointcut(featureToggleSkip)")
    public Object featureToggleSkip(ProceedingJoinPoint joinPoint, FeatureToggleSkip featureToggleSkip) throws Throwable {
        String methodName = ((MethodSignature) joinPoint.getSignature()).getMethod().getName();
        String className = joinPoint.getSignature().getDeclaringTypeName();

        if (featureToggleSkip == null) {
            // Se a anotação não estiver presente diretamente no método, tenta procurar na classe
            Class<?> targetClass = joinPoint.getTarget().getClass();
            featureToggleSkip = AnnotationUtils.findAnnotation(targetClass, FeatureToggleSkip.class);
        }

        if (featureToggleSkip != null) {
            String skip = environment.getProperty(featureToggleSkip.value());
            if (Boolean.parseBoolean(skip)) {
                System.out.println("Pulando a execução do método " + methodName + " da classe " + className);
                return false;
            }
        }

        System.out.println("Executando o método " + methodName + " da classe " + className);
        return joinPoint.proceed();
    }
}
