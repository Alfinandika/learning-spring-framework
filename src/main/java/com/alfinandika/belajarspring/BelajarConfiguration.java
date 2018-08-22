package com.alfinandika.belajarspring;

import com.alfinandika.belajarspring.model.DataBean;
import com.alfinandika.belajarspring.model.OtherBean;
import com.alfinandika.belajarspring.model.SampleBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import java.util.UUID;

@SpringBootApplication
public class BelajarConfiguration {

    @Bean(name="alfin")
    @Scope("prototype")
    public DataBean createDataBean(){
        String random = UUID.randomUUID().toString();
        DataBean bean = new DataBean(random);

        return bean;
    }

    @Bean(name="andika")
    //@Primary
    public DataBean createDataBean2(){
        DataBean bean = new DataBean("Andika");

        return bean;
    }

    @Bean
    public SampleBean createSampleBean(@Qualifier("alfin") DataBean dataBean){
        SampleBean bean = new SampleBean(dataBean);

        return bean;
    }

    @Bean
    public OtherBean createOtherBean(@Qualifier("andika") DataBean dataBean, SampleBean sampleBean){
        OtherBean bean = new OtherBean(dataBean, sampleBean);

        return bean;
    }
}
