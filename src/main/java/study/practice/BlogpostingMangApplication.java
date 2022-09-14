package study.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
//@EnableWebMvc
public class BlogpostingMangApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogpostingMangApplication.class, args);
		System.out.println("Blog  post Applicatoin Running.........");
	}

}
