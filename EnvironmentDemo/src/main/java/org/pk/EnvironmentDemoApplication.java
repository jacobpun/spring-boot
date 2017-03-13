package org.pk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.env.Environment;

@SpringBootApplication
@EnableConfigurationProperties
public class EnvironmentDemoApplication {

	@Value("${company.name}")
	void setCompanyName(String companyName) {
		System.out.println("Setting company name: " + companyName);
	}
	
	@Autowired
	void setEnvironment(Environment e) {
		System.out.println("Setting company name: " + e.getProperty("company.name"));
	}
	
	@Autowired
	void setCompany(CompanyProperties c) {
		System.out.println("Company Name is: " + c.getName());
		System.out.println("Address: " + 
				String.join(", ", 
						c.getAddress().getStreet(),  
						c.getAddress().getCity(), 
						c.getAddress().getState(),
						c.getAddress().getCountry()
						)
				);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(EnvironmentDemoApplication.class, args);
	}
}