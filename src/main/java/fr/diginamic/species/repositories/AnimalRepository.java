package fr.diginamic.species.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.diginamic.species.entities.Animal;
import fr.diginamic.species.entities.Species;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

	List<Animal> findBySpecies(Species species);
	
	List<Animal> findByColorIn(List<String> colors);
}
