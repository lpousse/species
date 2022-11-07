package fr.diginamic.species.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.species.entities.Animal;
import fr.diginamic.species.repositories.AnimalRepository;

@Service
public class AnimalService {

	@Autowired
	private AnimalRepository animalRepo;
	
	public List<Animal> findAll()
	{
		return animalRepo.findAll();
	}
	
	public Animal searchById(Integer id) throws RuntimeException
	{
		return animalRepo.findById(id).orElseThrow(() -> new RuntimeException("Animal whith ID " + id + " does not exist"));
	}
	
	public Animal save(Animal animal)
	{
		return animalRepo.save(animal);
	}
	
	public void delete(Integer id) throws RuntimeException
	{
		Animal animal = searchById(id);
		animalRepo.delete(animal);
	}
}
