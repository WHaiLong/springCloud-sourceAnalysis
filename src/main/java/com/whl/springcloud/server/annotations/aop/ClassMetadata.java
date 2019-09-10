package com.whl.springcloud.server.annotations.aop;


import org.springframework.lang.Nullable;

/**
 * 类的元数据
 *
 * @author WangHaiLong
 */
public interface ClassMetadata {

    /*
    * 获取类名
    * */
    String getClassName();

    /*
     * 是否是接口
     * */
    boolean isInterface();

    /*
     * 是否是注解
     * */
    boolean isAnnotation();

    /*
     * 是否是抽象
     * */
    boolean isAbstract();

    /*
     *
     * */
    boolean isConcrete();

    /*
     * 是否被final修饰
     * */
    boolean isFinal();

    /*
     * 是否
     * */
    boolean isIndependent();

    /*
     * 是否包含类
     * */
    boolean hasEnclosingClass();

    /*
     * 获取包含类的名称
     * */
    @Nullable
    String getEnclosingClassName();

    /*
     * 是否有父类
     * */
    boolean hasSuperClass();

    /*
     * 获取父类的名称
     * */
    @Nullable
    String getSuperClassName();

    /*
     * 获取该类实现的接口名称集合
     * */
    String[] getInterfaceNames();

    /*
     * 获取成员类名称集合
     * */
    String[] getMemberClassNames();
}

