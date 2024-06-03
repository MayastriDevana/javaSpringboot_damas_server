package com.damas.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.damas.dbbcassdmdev.model.Users;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.damas.dbbcassdmdev", entityManagerFactoryRef = "dbbcassdmdevEntityManagerFactory", transactionManagerRef = "dbbcassdmdevTransactionManager")
public class DbBcassdmdevConfig {

	@Bean
	@ConfigurationProperties("spring.datasource.dbbcassdmdev")
	public DataSourceProperties dbbcassdmdevDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean
	@ConfigurationProperties("spring.datasource.dbbcassdmdev.configuration")
	public DataSource dbbcassdmdevDataSource() {
		return dbbcassdmdevDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
	}

	@Bean(name = "dbbcassdmdevEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean dbbcassdmdevEntityManagerfactory(EntityManagerFactoryBuilder builder) {
		return builder
				.dataSource(dbbcassdmdevDataSource())
				.packages(Users.class)
				.build();
	}

	@Bean(name = "dbbcassdmdevTransactionManager")
	public PlatformTransactionManager dbbcassdmdevTransactionManager(
			final @Qualifier("dbbcassdmdevEntityManagerFactory") LocalContainerEntityManagerFactoryBean dbbcassdmdevEntityManagerFactory) {
		return new JpaTransactionManager(dbbcassdmdevEntityManagerFactory.getObject());
	}

}
