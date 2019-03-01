package br.com.recanto.terapia;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan
//@EnableJpaRepositories(basePackages = {"br.com.recanto.terapia"})
//@EntityScan(basePackages = {"br.com.recanto.terapia"})
//@ComponentScan(basePackages = {"br.com.recanto.terapia", "br.com.recanto.terapia.model"})
@EnableJpaRepositories("br.com.recanto.terapia.repository")
public class RecantoTerapiaBackendApiApplication {

	public static void main(String[] args) {
		System.setProperty("spring.devtools.restart.enabled", "false");
		System.setProperty("spring.devtools.livereload.enabled", "true");
		SpringApplication.run(RecantoTerapiaBackendApiApplication.class, args);
	}

}
