package com.whl.springcloud.server.annotations;

import java.lang.annotation.*;

/**
 * Description
 * User:whl
 * Date:2019-09-10 12:05
 */
@Target({ElementType.TYPE}) // 使用在类、接口、枚举
@Retention(RetentionPolicy.RUNTIME) // 将会被编译器记录在类文件中
@Documented // 标记为元注解（元注解特点：会被子类继承该注解）
@SpringBootConfiguration // 配置类
@EnableAutoConfiguration // 开启自动扫描配置文件
public @interface SpringBootApplication {

}
