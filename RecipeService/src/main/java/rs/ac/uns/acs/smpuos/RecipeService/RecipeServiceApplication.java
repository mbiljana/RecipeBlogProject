package rs.ac.uns.acs.smpuos.RecipeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableEurekaClient
@EnableMongoRepositories
public class RecipeServiceApplication {

	@Autowired
	InitialData initialData;
	public static void main(String[] args) {
		SpringApplication.run(RecipeServiceApplication.class, args);
	}
}
