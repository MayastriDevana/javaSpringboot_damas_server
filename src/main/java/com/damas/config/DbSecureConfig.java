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

import com.damas.dbsecure.model.Tuser;
import com.damas.dbsecure.model.UsrAplikasi;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.damas.dbsecure", entityManagerFactoryRef = "dbsecureEntityManagerFactory", transactionManagerRef = "dbsecureTransactionManager")
public class DbSecureConfig {

	@Bean
	@ConfigurationProperties("spring.datasource.dbsecure")
	public DataSourceProperties dbsecureDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean
	@ConfigurationProperties("spring.datasource.dbsecure.configuration")
	public DataSource dbsecureDataSource() {
		return dbsecureDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
	}

	@Bean(name = "dbsecureEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean dbsecureEntityManagerfactory(EntityManagerFactoryBuilder builder) {
		return builder
				.dataSource(dbsecureDataSource())
				.packages(Tuser.class, UsrAplikasi.class)
				.build();
	}

	@Bean(name = "dbsecureTransactionManager")
	public PlatformTransactionManager dbsecureTransactionManager(
			final @Qualifier("dbsecureEntityManagerFactory") LocalContainerEntityManagerFactoryBean dbsecureEntityManagerFactory) {
		return new JpaTransactionManager(dbsecureEntityManagerFactory.getObject());
	}

}
