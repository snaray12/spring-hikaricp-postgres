package com.example;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SpringHikaricpPostgresApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHikaricpPostgresApplication.class, args);
	}
	
	@Bean(name="primary")
	@Primary
	@ConfigurationProperties(prefix="spring.datasource.primary")
	public DataSource primaryDataSource() {
	    return DataSourceBuilder.create().build();
	}

	@Bean(name="secondary")
	@ConfigurationProperties(prefix="spring.datasource.secondary")
	public DataSource secondaryDataSource() {
	    return DataSourceBuilder.create().build();
	}
	
	@Bean(name="one")
	public JdbcTemplate primaryJdbcTemplate(@Autowired @Qualifier("primary") DataSource ds) {
		return new JdbcTemplate(ds);
	}
	
	@Bean(name="two")
	public JdbcTemplate secondaryJdbcTemplate(@Autowired @Qualifier("secondary") DataSource ds) {
		return new JdbcTemplate(ds);
	}
}
