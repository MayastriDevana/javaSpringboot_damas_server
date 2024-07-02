package com.damas.config;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.damas.dbdamas.model.User;
import com.damas.dbdamas.model.Logistic.LogisticMemo;
import com.damas.dbdamas.model.Operation.OperationNetwork;
import com.damas.dbdamas.model.Projectdev.ProjectDev;
import com.damas.dbdamas.model.Projectdev.Skse;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.damas.dbdamas", entityManagerFactoryRef = "dbdamasEntityManagerFactory", transactionManagerRef = "dbdamasTransactionManager")
public class DbDamasConfig {
    @Bean 
    @ConfigurationProperties("spring.datasource.dbdamas")
    public DataSourceProperties dbdamasDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.dbdamas.configuration")
    public DataSource dbdamasDataSource() {
        return dbdamasDataSourceProperties().initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
    }

    @Bean
    public EntityManagerFactoryBuilder entityManagerFactoryBuilder() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(false);
        return new EntityManagerFactoryBuilder(vendorAdapter, new HashMap<>(), null);
    }

    @Primary
    @Bean(name = "dbdamasEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean dbdamasEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(dbdamasDataSource())
                .packages(User.class, Skse.class, ProjectDev.class, OperationNetwork.class, LogisticMemo.class)
                .build();
    }

    @Primary
    @Bean(name = "dbdamasTransactionManager")
    public PlatformTransactionManager dbdamasTransactionManager(
        final @Qualifier("dbdamasEntityManagerFactory") LocalContainerEntityManagerFactoryBean dbdamasEntityManagerFactory) {
        return new JpaTransactionManager(dbdamasEntityManagerFactory.getObject());
    }

}