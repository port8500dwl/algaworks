package br.com.recanto.terapia;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = {"br.com.recanto.terapia"})
//@EntityScan(basePackages = {"br.com.recanto.terapia"})
@ComponentScan(basePackages = {"br.com.recanto.terapia", "br.com.recanto.terapia.model"})
public class RecantoTerapiaBackendApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecantoTerapiaBackendApiApplication.class, args);
	}

}
