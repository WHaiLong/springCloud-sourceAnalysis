package com.whl.springcloud.server.annotations.aop;


import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Set;

/**
 * 注解的元数据
 * @author WangHaiLong
 */
public interface AnnotationMetadata extends ClassMetadata, AnnotatedTypeMetadata {

    /**
     * 获取注解的类型集合
     */
    Set<String> getAnnotationTypes();

    /**
     * 获取元注解类型集合
     */
    Set<String> getMetaAnnotationTypes(String var1);

    /**
     * 判断是否有注解
     */
    boolean hasAnnotation(String var1);

    /**
     * 判断是否有元注解
     */
    boolean hasMetaAnnotation(String var1);

    /**
     * 判断是否有注解的方法
     */
    boolean hasAnnotatedMethods(String var1);

    /**
     * 获取所有的注解方法
     */
    Set<MethodMetadata> getAnnotatedMethods(String var1);
}

