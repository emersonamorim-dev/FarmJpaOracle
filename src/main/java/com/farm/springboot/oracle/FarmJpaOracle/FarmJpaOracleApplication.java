package com.farm.springboot.oracle.FarmJpaOracle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication
public class FarmJpaOracleApplication {

	public static void main(String[] args) {
		SpringApplication.run(FarmJpaOracleApplication.class, args);
	}

	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		driverManagerDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		driverManagerDataSource.setUsername("ADMIN");
		driverManagerDataSource.setPassword("ADMIN");
		return driverManagerDataSource;
	}

}
