package com.whl.springcloud.server.annotations;

import com.whl.springcloud.server.annotations.aop.AutoConfigurationImportSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * Description
 * User:whl
 * Date:2019-09-10 12:33
 * @author WangHaiLong
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@AutoConfigurationPackage
@Import({AutoConfigurationImportSelector.class})
public @interface EnableAutoConfiguration {

    String ENABLED_OVERRIDE_PROPERTY = "spring.boot.enableautoconfiguration";

    Class<?>[] exclude() default {};

    String[] excludeName() default {};
}
