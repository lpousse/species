package fr.diginamic.species.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import fr.diginamic.species.enums.Sex;

@Entity
@Table(name = "animal")
public class Animal extends BaseEntity{

	@NotEmpty
	@Size(max = 50)
	private String color;
	
	@NotEmpty
	@Size(max = 50)
	private String name;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private Sex sex;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "species_id")
	private Species species;
	
	@ManyToMany(mappedBy = "animals")
	List<Person> persons;
	
	public Animal() {
		super();
		persons = new ArrayList<>();
	}
	
	public Animal(String color, String name, Sex sex, Species species) {
		this();
		this.color = color;
		this.name = name;
		this.sex = sex;
		this.species = species;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public Species getSpecies() {
		return species;
	}

	public void setSpecies(Species species) {
		this.species = species;
	}
	
	@Override
	public String toString() {
		return "[id: " + getId() + "; color: " + getColor() + "; name: " + getName() + "; sex: " + getSex() +"]";
	}
}
