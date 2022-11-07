package fr.diginamic.species.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.species.entities.Person;
import fr.diginamic.species.repositories.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepo;
	
	public List<Person> findAll()
	{
		return personRepo.findAll();
	}
	
	public Person searchById(Integer id) throws RuntimeException
	{
		return personRepo.findById(id).orElseThrow(() -> new RuntimeException("Animal whith ID " + id + " does not exist"));
	}
	
	public Person save(Person person)
	{
		return personRepo.save(person);
	}
	
	public void delete(Integer id) throws RuntimeException
	{
		Person person = searchById(id);
		personRepo.delete(person);
	}
}
