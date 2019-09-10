package com.whl.springcloud.server.annotations;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

import com.whl.springcloud.server.annotations.aop.AutoConfigurationPackages.*;


/**
 *
 * @author WangHaiLong
 */
@Target(ElementType.TYPE)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Import({Registrar.class})
public @interface AutoConfigurationPackage {
}
