package com.whl.springcloud.server.annotations.aop;

import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 方法的元数据
 * @author WangHaiLong
 */
public interface MethodMetadata extends AnnotatedTypeMetadata {

    /**
     * 获取方法的名字
     */
    String getMethodName();

    /**
     * 获取声明类的名字
     */
    String getDeclaringClassName();

    /**
     * 获取返回类型的名字
     */
    String getReturnTypeName();

    /**
     * 是否是抽象方法
     */
    boolean isAbstract();

    /**
     * 是否是静态方法
     */
    boolean isStatic();

    /**
     * 是否被final修饰
     */
    boolean isFinal();

    /**
     * 是否重写
     */
    boolean isOverridable();
}