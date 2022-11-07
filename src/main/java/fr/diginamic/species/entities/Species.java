package fr.diginamic.species.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "species")
public class Species extends BaseEntity {
	
	@NotEmpty
	@Size(max = 50)
	private String commonName;
	
	@NotEmpty
	@Size(max = 120)
	private String latinName;
	
	@OneToMany(mappedBy = "species")
	List<Animal> animals;
	
	public Species() {
		super();
		animals = new ArrayList<>();
	}

	public Species(String commonName, String latinName) {
		this();
		this.commonName = commonName;
		this.latinName = latinName;
	}

	public String getCommonName() {
		return commonName;
	}

	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}

	public String getLatinName() {
		return latinName;
	}

	public void setLatinName(String latinName) {
		this.latinName = latinName;
	}

	public List<Animal> getAnimals() {
		return animals;
	}

	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}
	
	@Override
	public String toString() {
		return "[id: " + getId() + "; commonName: " + getCommonName() + "; latinName: " + getLatinName() + "]";
	}
}
