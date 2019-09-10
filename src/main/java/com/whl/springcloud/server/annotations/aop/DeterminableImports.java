package com.whl.springcloud.server.annotations.aop;
import java.util.Set;
import org.springframework.core.type.AnnotationMetadata;

@FunctionalInterface
public interface DeterminableImports {
    Set<Object> determineImports(AnnotationMetadata metadata);
}