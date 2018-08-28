package com.alfinandika.belajarspring;

import com.alfinandika.belajarspring.model.Author;
import com.alfinandika.belajarspring.model.DataBean;
import com.alfinandika.belajarspring.model.OtherBean;
import com.alfinandika.belajarspring.model.SampleBean;
import com.alfinandika.belajarspring.service.DatabaseConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.Validator;
import java.util.UUID;

@SpringBootApplication
@PropertySources({
        @PropertySource("classpath:/configuration/contoh.properties")
})
public class BelajarConfiguration {

    @Autowired
    private Environment environment;

    @Bean(name="alfin")
    @Scope("prototype") //kalau dirubah menjadi singeton maka setiap bean yg dipanggil tidak akan membuat object baru
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

    @Bean
    @Profile("development")
    public DatabaseConfig createDevDatabaseConfig(){
        return new DatabaseConfig("Database Development");
    }

    @Bean
    @Profile("production")
    public DatabaseConfig createProdDatabaseConfig(){
        return new DatabaseConfig("Database Production");
    }

    @Bean(name="messageSource")
    public MessageSource createMessageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages.hello");

        return messageSource;
    }

    @Bean
    public Validator createValidator(){
        return new LocalValidatorFactoryBean();
    }
}
