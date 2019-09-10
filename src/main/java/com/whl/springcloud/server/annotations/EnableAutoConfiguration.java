package com.whl.springcloud.server.annotations;

import java.lang.annotation.*;

/**
 * Description
 * User:whl
 * Date:2019-09-10 12:33
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface EnableAutoConfiguration {
}
