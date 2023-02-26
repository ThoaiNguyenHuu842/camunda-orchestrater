package com.thoainguyen;

import java.util.UUID;
import javax.sql.DataSource;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.h2.engine.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.thoainguyen.client")
@EnableProcessApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public DataSource h2DataSource() {
		EmbeddedDatabase embeddedDatabase = new EmbeddedDatabaseBuilder()
			.setType(EmbeddedDatabaseType.H2)
			.setName(UUID.randomUUID() + ";Mode=Oracle;DEFAULT_NULL_ORDERING=HIGH")
			.build();
		Mode mode = Mode.getInstance("ORACLE");
		mode.limit = true;
		// Here is the trick
		mode.numericWithBooleanComparison = true;
		return embeddedDatabase;
	}
}
