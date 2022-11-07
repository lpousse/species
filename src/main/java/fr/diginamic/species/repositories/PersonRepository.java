package fr.diginamic.species.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.diginamic.species.entities.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
	
	List<Person> findByLastNameOrFirstName(String lastName, String firstName);
	
	List<Person> findByAgeGreaterThanEqual(Integer age);
}
