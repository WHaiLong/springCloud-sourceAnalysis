package com.whl.springcloud.server.annotations.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * 自动配置包
 *
 * @author WangHaiLong
 */
public abstract class AutoConfigurationPackages {

    private static final Log logger = LogFactory.getLog(AutoConfigurationPackages.class);

    private static final String BEAN = AutoConfigurationPackages.class.getName();

    public AutoConfigurationPackages() {
    }

    public static boolean has(BeanFactory beanFactory) {
        return beanFactory.containsBean(BEAN) && !get(beanFactory).isEmpty();
    }

    public static List<String> get(BeanFactory beanFactory) {
        try {
            return ((AutoConfigurationPackages.BasePackages) beanFactory.getBean(BEAN, AutoConfigurationPackages.BasePackages.class)).get();
        } catch (NoSuchBeanDefinitionException var2) {
            throw new IllegalStateException("Unable to retrieve @EnableAutoConfiguration base packages");
        }
    }

    public static void register(BeanDefinitionRegistry registry, String... packageNames) {
        // 判断是否包含自动配置类
        if (registry.containsBeanDefinition(BEAN)) {
            // 获取该对象的信息
            BeanDefinition beanDefinition = registry.getBeanDefinition(BEAN);
            // 获取构造参数的值
            ConstructorArgumentValues constructorArguments = beanDefinition.getConstructorArgumentValues();
            // 添加索引对应的自变量值
            constructorArguments.addIndexedArgumentValue(0, addBasePackages(constructorArguments, packageNames));
        } else {
            GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
            beanDefinition.setBeanClass(AutoConfigurationPackages.BasePackages.class);
            beanDefinition.getConstructorArgumentValues().addIndexedArgumentValue(0, packageNames);
            beanDefinition.setRole(2);
            registry.registerBeanDefinition(BEAN, beanDefinition);
        }

    }

    private static String[] addBasePackages(ConstructorArgumentValues constructorArguments, String[] packageNames) {
        String[] existing = (String[]) ((String[]) constructorArguments.getIndexedArgumentValue(0, String[].class).getValue());
        Set<String> merged = new LinkedHashSet();
        merged.addAll(Arrays.asList(existing));
        merged.addAll(Arrays.asList(packageNames));
        return StringUtils.toStringArray(merged);
    }

    static final class BasePackages {
        private final List<String> packages;
        private boolean loggedBasePackageInfo;

        BasePackages(String... names) {
            List<String> packages = new ArrayList();
            String[] var3 = names;
            int var4 = names.length;

            for (int var5 = 0; var5 < var4; ++var5) {
                String name = var3[var5];
                if (StringUtils.hasText(name)) {
                    packages.add(name);
                }
            }

            this.packages = packages;
        }

        public List<String> get() {
            if (!this.loggedBasePackageInfo) {
                if (this.packages.isEmpty()) {
                    if (AutoConfigurationPackages.logger.isWarnEnabled()) {
                        AutoConfigurationPackages.logger.warn("@EnableAutoConfiguration was declared on a class in the default package. Automatic @Repository and @Entity scanning is not enabled.");
                    }
                } else if (AutoConfigurationPackages.logger.isDebugEnabled()) {
                    String packageNames = StringUtils.collectionToCommaDelimitedString(this.packages);
                    AutoConfigurationPackages.logger.debug("@EnableAutoConfiguration was declared on a class in the package '" + packageNames + "'. Automatic @Repository and @Entity scanning is enabled.");
                }

                this.loggedBasePackageInfo = true;
            }

            return this.packages;
        }
    }

    private static final class PackageImport {
        private final String packageName;

        PackageImport(AnnotationMetadata metadata) {
            // 获取该类的包路径
            this.packageName = ClassUtils.getPackageName(metadata.getClassName());
        }

        public String getPackageName() {
            return this.packageName;
        }

        @Override
        public boolean equals(Object obj) {
            return obj != null && this.getClass() == obj.getClass() ? this.packageName.equals(((AutoConfigurationPackages.PackageImport) obj).packageName) : false;
        }

        @Override
        public int hashCode() {
            return this.packageName.hashCode();
        }

        @Override
        public String toString() {
            return "Package Import " + this.packageName;
        }
    }

    public static class Registrar implements ImportBeanDefinitionRegistrar, DeterminableImports {
        Registrar() {
        }

        /*
         * 功能：注册
         * */
        @Override
        public void registerBeanDefinitions(AnnotationMetadata metadata, BeanDefinitionRegistry registry) {
            // 通过类信息获取对应的包名
            String packageName = (new PackageImport(metadata)).getPackageName();
            // 注册配置类
            AutoConfigurationPackages.register(registry, packageName);
        }

        @Override
        public Set<Object> determineImports(AnnotationMetadata metadata) {
            return Collections.singleton(new AutoConfigurationPackages.PackageImport(metadata));
        }
    }
}
