package lt.codeacademy.springautoservisas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:company.properties")
public class SpringAutoservisasApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAutoservisasApplication.class, args);
	}

}
