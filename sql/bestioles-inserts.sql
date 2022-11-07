INSERT INTO species (id, common_name, latin_name) VALUES
	(1, 'Chat', 'Felis silvestris catus'),
	(2, 'Chien', 'Canis lupus familiaris'),
	(3, 'Lapin', 'Oryctolagus cuniculus');


INSERT INTO `person` (id , firstname , lastname , age) VALUES
	(1, 'Henri', 'Lamarque', 22),
	(2, 'Sylvie', 'Lamarque', 24),
	(3, 'Jean', 'Vintroi', 55),
	(4, 'Paul', 'Demaine', 80),
	(5, 'Sophie', 'Nero', 45),
	(6, 'Pierre', 'Sansane', 17),
	(7, 'John', 'Mangolo', 33),
	(8, 'Bill', 'Wagner', 26);
	
INSERT INTO `animal` (id, species_id , name, color, sex) VALUES
	(1, 1, 'Max', 'Gris tacheté', 'M'),
	(2, 2, 'Médor', 'Blanc', 'M'),
	(3, 1, 'Loulou', 'Noir', 'F'),
	(4, 2, 'Zia', 'Brun', 'F'),
	(5, 3, 'Lou', 'Blanc', 'F'),
	(6, 1, 'Minouchette', 'Roux', 'M');
	
INSERT INTO person_animals (person_id , animals_id) VALUES
	(2, 1),
	(2, 5),
	(3, 3),
	(4, 2),
	(5, 4),
	(7, 1),
	(8, 6);