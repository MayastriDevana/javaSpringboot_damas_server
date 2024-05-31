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

import com.damas.dbbcas_sdmdev.model.Users;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.damas.dbbcas_sdmdev", entityManagerFactoryRef = "dbbcas_sdmdevEntityManagerFactory", transactionManagerRef = "dbbcas_sdmdevTransactionManager")
public class DbBcas_sdmdevConfig {

	@Bean
	@ConfigurationProperties("spring.datasource.dbbcas_sdmdev")
	public DataSourceProperties dbbcas_sdmdevDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean
	@ConfigurationProperties("spring.datasource.dbbcas_sdmdev.configuration")
	public DataSource dbbcas_sdmdevDataSource() {
		return dbbcas_sdmdevDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
	}

	@Bean(name = "dbbcas_sdmdevEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean dbbcas_sdmdevEntityManagerfactory(EntityManagerFactoryBuilder builder) {
		return builder
				.dataSource(dbbcas_sdmdevDataSource())
				.packages(Users.class)
				.build();
	}

	@Bean(name = "dbbcas_sdmdevTransactionManager")
	public PlatformTransactionManager dbbcas_sdmdevTransactionManager(
			final @Qualifier("dbbcas_sdmdevEntityManagerFactory") LocalContainerEntityManagerFactoryBean dbbcas_sdmdevEntityManagerFactory) {
		return new JpaTransactionManager(dbbcas_sdmdevEntityManagerFactory.getObject());
	}

}
