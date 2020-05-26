package com.sowa.test.spring.jpa.hibernate.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.context.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jca.context.BootstrapContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;
import org.springframework.web.context.ServletContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletContext;

@Component
@Slf4j
public class SpringLifecycleDemoBean implements InitializingBean, DisposableBean, ApplicationContextAware, ApplicationEventPublisherAware,
        BeanClassLoaderAware, BeanFactoryAware, BeanNameAware, EnvironmentAware, EmbeddedValueResolverAware, ResourceLoaderAware, MessageSourceAware,
        ServletContextAware, BeanPostProcessor, DestructionAwareBeanPostProcessor {

/* Order
*  1. Bean Aware's
*  2. postProcessBeforeInitialization methods of BeanPostProcessors
*  3. InitializingBean's afterPropertiesSet
*  4. custom init-method
*  5. postProcessAfterInitialization methods of BeanPostProcessors
*   SHUTDOWN
*  1. postProcessBeforeDestruction methods of DestructionAwareBeanPostProcessors
*  2. DisposableBean's destroy
*  3. custom destroy-method
* */
    //INITIALIZATION
    @PostConstruct
    public void postConstructMethod(){
        log.info("SPRING LIFECYCLE: @PostConstruct annotated method ");
    }
    @PreDestroy
    public void preDestroyMethod(){
        log.info("SPRING LIFECYCLE: @PreDestroy annotated method ");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("SPRING LIFECYCLE: ApplicationContextAware method setApplicationContext(ApplicationContext applicationContext): " + applicationContext.getId());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("SPRING LIFECYCLE: afterPropertiesSet() method from InitializingBean interface");
    }

    @Override
    public void destroy() throws Exception {
        log.info("SPRING LIFECYCLE: destroy() method from DisposableBean interface");
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        log.info("SPRING LIFECYCLE: ApplicationEventPublisherAware method can publish ApplicationEvents: ");
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        log.info("SPRING LIFECYCLE: BeanClassLoaderAware method can use actual beanFactory class loader: " + classLoader.getName());
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        log.info("SPRING LIFECYCLE: BeanFactoryAware method can use actual beanFactory to retrieve beans and bean types.");
    }

    @Override
    public void setBeanName(String s) {
        log.info("SPRING LIFECYCLE: BeanNameAware method can use actual beanName: " + s);
    }

    @Override
    public void postProcessBeforeDestruction(Object o, String s) throws BeansException {

    }

    @Override
    public boolean requiresDestruction(Object bean) {
        return false;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {

    }

    @Override
    public void setEnvironment(Environment environment) {

    }

    @Override
    public void setMessageSource(MessageSource messageSource) {

    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {

    }

    @Override
    public void setServletContext(ServletContext servletContext) {

    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        //log.info("SPRING LIFECYCLE: Called postProcessBeforeInitialization() for :" + beanName);  //All beans displayed lots of logs
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //log.info("SPRING LIFECYCLE: Called postProcessAfterInitialization() for :" + beanName); //All beans displayed lots of logs
        return bean;
    }

    //SHUTDOWN

}
