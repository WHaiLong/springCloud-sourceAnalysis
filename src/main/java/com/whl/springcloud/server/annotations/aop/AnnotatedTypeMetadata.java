package com.whl.springcloud.server.annotations.aop;


import java.util.Map;
import org.springframework.lang.Nullable;
import org.springframework.util.MultiValueMap;

public interface AnnotatedTypeMetadata {
    boolean isAnnotated(String var1);

    /**
     * 获取注解的属性
     */
    @Nullable
    Map<String, Object> getAnnotationAttributes(String var1);

    /**
     * 获取注解的属性
     */
    @Nullable
    Map<String, Object> getAnnotationAttributes(String var1, boolean var2);

    /**
     * 获取注解的属性
     */
    @Nullable
    MultiValueMap<String, Object> getAllAnnotationAttributes(String var1);

    /**
     * 获取注解的属性
     */
    @Nullable
    MultiValueMap<String, Object> getAllAnnotationAttributes(String var1, boolean var2);
}