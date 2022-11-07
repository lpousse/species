package fr.diginamic.species.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.species.entities.Species;
import fr.diginamic.species.repositories.SpeciesRepository;

@Service
public class SpeciesService {

	@Autowired
	private SpeciesRepository speciesRepo;
	
	public List<Species> findAll()
	{
		return speciesRepo.findAll();
	}
	
	public Species searchById(Integer id) throws RuntimeException
	{
		return speciesRepo.findById(id).orElseThrow(() -> new RuntimeException("Species with ID " + id + " does not exist"));
	}
	
	public Species save(Species species)
	{
		return speciesRepo.save(species);
	}
	
	public void delete(Integer id) throws RuntimeException
	{
		Species person = searchById(id);
		speciesRepo.delete(person);
	}
}
