package fr.diginamic.species.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.diginamic.species.entities.Species;

@Repository
public interface SpeciesRepository extends JpaRepository<Species, Integer> {

	Optional<Species> findFirstByCommonName(String commonName);
	
	List<Species> findByLatinNameContainingIgnoreCase(String latinName);
}
