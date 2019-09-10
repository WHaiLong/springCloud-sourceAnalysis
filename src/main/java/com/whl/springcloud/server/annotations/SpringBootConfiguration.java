package com.whl.springcloud.server.annotations;

import org.springframework.context.annotation.Configuration;

import java.lang.annotation.*;

/**
 * Description
 * User:whl
 * Date:2019-09-10 12:26
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Configuration // 标记为配置类
public @interface SpringBootConfiguration {
}
