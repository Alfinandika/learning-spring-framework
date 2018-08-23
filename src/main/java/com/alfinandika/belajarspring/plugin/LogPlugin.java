package com.alfinandika.belajarspring.plugin;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.stereotype.Component;

@Component
public class LogPlugin extends InstantiationAwareBeanPostProcessorAdapter {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("telah dibuat bean dengan nama "+beanName+" dengan type "+bean.getClass().getName());

        return bean;
    }
}
