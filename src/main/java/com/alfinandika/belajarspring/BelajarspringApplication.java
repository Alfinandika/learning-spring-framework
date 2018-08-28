package com.alfinandika.belajarspring;

import com.alfinandika.belajarspring.model.*;
import com.alfinandika.belajarspring.service.DatabaseConfig;
import com.alfinandika.belajarspring.service.UserService;
import com.alfinandika.belajarspring.validation.AuthorValidator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.io.IOException;
import java.util.Locale;
import java.util.Set;

public class BelajarspringApplication {


	public static void main(String[] args) throws IOException {

		//set profile
		System.setProperty("spring.profiles.active", "production");
		Locale.setDefault(new Locale("in", "ID"));

		ApplicationContext context = SpringApplication.run(BelajarConfiguration.class, args);





		//DataBean dataBean = context.getBean(DataBean.class);
		//System.out.println(dataBean.getValue());

		//SampleBean sampleBean = context.getBean(SampleBean.class);
		//System.out.println(sampleBean.getDataBean().getValue());

		//OtherBean otherBean = context.getBean(OtherBean.class);

		//System.out.println(otherBean.getDataBean().getValue());
		//System.out.println(otherBean.getSampleBean().getDataBean().getValue());
		//sayHello sayHello = context.getBean(sayHello.class);
		//String hello = sayHello.hello("alfin");

		//System.out.println(hello);

		//Belajar dan memahami Scope
		//DataBean alfin1 = context.getBean("alfin", DataBean.class);
		//System.out.println(alfin1.getValue());

		//DataBean alfin2 = context.getBean("alfin", DataBean.class);
		//System.out.println(alfin2.getValue());

		//DataBean alfin3 = context.getBean("alfin", DataBean.class);
		//System.out.println(alfin3.getValue());

		//SampleBean sampleBean = context.getBean(SampleBean.class);
		//System.out.println(sampleBean.getDataBean().getValue());

		//DatabaseConfig config = context.getBean(DatabaseConfig.class);
		//System.out.println(config.getValue());

		//FileBean fileBean = context.getBean(FileBean.class);
		//fileBean.printInfo();

//		MessageSource messageSource = context.getBean(MessageSource.class);
//
//		Author author = new Author("alfin", "alfin@andika.com");
//		DataBinder binder = new DataBinder(author);
//		binder.addValidators(new AuthorValidator());
//		binder.validate();
//
//		BindingResult result = binder.getBindingResult();
//
//		if(result.hasErrors()){
//			result.getAllErrors().stream().forEach((errorGan) -> {
//				String message = messageSource.getMessage(errorGan.getCode(), null, Locale.getDefault());
//
//				System.out.println(message);
//			});
//		}else{
//			System.out.println("tidak ada error");
//		}

		Validator validator = context.getBean(Validator.class);

		User user = new User();
		user.setEmail("salah");
		user.setId("0");
		user.setName("");

//		Set<ConstraintViolation<User>> result =  validator.validate(user);
//
//		result.forEach((constraint) -> {
//			System.out.println(constraint.getMessage());
//		});

		UserService service = context.getBean(UserService.class);


		try{
			service.save(user);
		}catch (ConstraintViolationException ex){
			ex.getConstraintViolations().stream().forEach((error) -> {
				System.out.println(error.getMessage());
			});
		}

		//Author author = context.getBean(Author.class);
		//System.out.println(author.getName());
		//System.out.println(author.getEmail());
	}
}
