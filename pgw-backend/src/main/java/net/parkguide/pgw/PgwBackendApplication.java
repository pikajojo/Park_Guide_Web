package net.parkguide.pgw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class PgwBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(PgwBackendApplication.class, args);
	}

}
