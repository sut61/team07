package SUT61.Team07.Drug;
import java.util.stream.Stream;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import SUT61.Team07.Drug.Entity.Drug;
import SUT61.Team07.Drug.Repository.DrugRepository;

@SpringBootApplication
public class DrugApplication {

	public static void main(String[] args) {
		SpringApplication.run(DrugApplication.class, args);
	}
	@Bean
    ApplicationRunner init(DrugRepository repository) {
        return args -> {
            Stream.of("Ferrari", "Jaguar", "Porsche", "Lamborghini", "Bugatti",
                      "AMC Gremlin", "Triumph Stag", "Ford Pinto", "Yugo GV").forEach(name -> {
                Drug car = new Drug();
                car.setName(name);
                repository.save(car);
            });
            repository.findAll().forEach(System.out::println);
        };
    }

}

