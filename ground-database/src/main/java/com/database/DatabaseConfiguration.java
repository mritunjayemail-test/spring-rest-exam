package com.database;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.database.core.GDTransactionManager;

@Configuration
@EnableCaching
@EnableAspectJAutoProxy
@ImportResource("classpath:/spring-xml/spring-resource.xml")
public class DatabaseConfiguration {

	@Bean
	@Profile("dev")
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		driverManagerDataSource.setUrl("jdbc:mysql://ashupost.cvkqavmqhnef.eu-west-1.rds.amazonaws.comr:3306/ashupost");
		driverManagerDataSource.setUsername("ashupost");
		driverManagerDataSource.setPassword("ashupost");

		return driverManagerDataSource;
	}

	@Bean
	@Profile("dev")
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}

	@Bean("dataSource")
	@Profile("prod")
	public DriverManagerDataSource dataSourceProd() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		driverManagerDataSource.setUrl("jdbc:mysql://ashupost.cvkqavmqhnef.eu-west-1.rds.amazonaws.com:3306/ashupost");
		driverManagerDataSource.setUsername("ashupost");
		driverManagerDataSource.setPassword("ashupost");

		return driverManagerDataSource;
	}

	@Bean("transactionManager")
	@Profile("prod")
	public DataSourceTransactionManager transactionManagerProd() {
		return new DataSourceTransactionManager(dataSource());
	}

	@Bean
	public GDTransactionManager gdTxManager() {
		GDTransactionManager transactionManager = new GDTransactionManager();
		transactionManager.setTransactionManager(transactionManager());
		return transactionManager;
	}

}