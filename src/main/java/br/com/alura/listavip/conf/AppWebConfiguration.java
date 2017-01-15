package br.com.alura.listavip.conf;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import br.com.alura.listavip.controllers.HomeController;
import br.com.alura.listavip.models.Convidado;
import br.com.alura.listavip.repository.ConvidadoRepository;

@ComponentScan(basePackageClasses={HomeController.class})
@EnableJpaRepositories(basePackageClasses={ConvidadoRepository.class})
@EntityScan(basePackageClasses={Convidado.class})
@SpringBootApplication
public class AppWebConfiguration {

	public static void main(String[] args){
		SpringApplication.run(AppWebConfiguration.class, args);
	}
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUsername("root");
		dataSource.setPassword("cursoalura");
		dataSource.setUrl("jdbc:mysql://localhost:3306/listavip");
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		return dataSource;
	}

}

