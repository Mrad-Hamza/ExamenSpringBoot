package tn.spring.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling

public class MradHamzaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MradHamzaApplication.class, args);
	}

}
