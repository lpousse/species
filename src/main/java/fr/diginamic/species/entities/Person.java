package fr.diginamic.species.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "person")
public class Person extends BaseEntity {

	@NotNull
	@Min(0)
	@Max(120)
	private int age;
	
	@NotEmpty
	@Size(max = 50)
	@Column(name="firstname")
	private String firstName;
	
	@NotEmpty
	@Size(max = 50)
	@Column(name="lastname")
	private String lastName;
	
	@ManyToMany
	@JoinTable(name = "person_animals",
			joinColumns = @JoinColumn(name = "person_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "animals_id", referencedColumnName = "id"))
	List<Animal> animals;
	
	public Person() {
		super();
		animals = new ArrayList<>();
	}

	public Person(int age, String firstName, String lastName) {
		this();
		this.age = age;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Animal> getAnimals() {
		return animals;
	}

	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}
	
	@Override
	public String toString() {
		return "[id: " + getId() + "; firstName: " + getFirstName() + "; lastName: " + getLastName() + "; age: " + getAge() +"]";
	}
}
