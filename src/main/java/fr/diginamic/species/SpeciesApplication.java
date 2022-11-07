package fr.diginamic.species;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import fr.diginamic.species.entities.Animal;
import fr.diginamic.species.enums.Sex;
import fr.diginamic.species.repositories.AnimalRepository;
import fr.diginamic.species.repositories.PersonRepository;
import fr.diginamic.species.repositories.SpeciesRepository;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpeciesApplication implements CommandLineRunner {

	@Autowired
	private PersonRepository personRepo;
	
	@Autowired
	private AnimalRepository animalRepo;
	
	@Autowired
	private SpeciesRepository speciesRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(SpeciesApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		/*personRepo.findAll().forEach(System.out::println);
		
		System.out.println(speciesRepo.findById(2));
		
		Animal chat = new Animal("Noir et Blanc", "Newton", Sex.M, speciesRepo.findById(1).get());
		chat = animalRepo.save(chat);
		System.out.println(chat);
		animalRepo.delete(chat);
		
		speciesRepo.findFirstByCommonName("Lapin").ifPresent(System.out::println);
		speciesRepo.findByLatinNameContainingIgnoreCase("ca").forEach(System.out::println);
		
		personRepo.findByLastNameOrFirstName("Lamarque", "Paul").forEach(System.out::println);
		personRepo.findByAgeGreaterThanEqual(45).forEach(System.out::println);
		
		animalRepo.findBySpecies(speciesRepo.findById(1).get()).forEach(System.out::println);
		animalRepo.findByColorIn(List.of("Blanc", "Brun", "Rouge")).forEach(System.out::println);*/
	}

}
