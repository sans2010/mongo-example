package com.example.mongo.resources;

import java.util.List;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongo.models.Pets;
import com.example.mongo.repositories.PetRepository;

@RestController
@RequestMapping("/pets")
public class PetsResource {

	@Autowired
	private PetRepository repository;
	
	@GetMapping
	public List<Pets> getAllPets() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Pets getPetById(@PathVariable ObjectId id) {
		return repository.findBy_id(id);
	}
	
	@PutMapping("/{id}")
	public Pets modifyPetById(@PathVariable("id") ObjectId id, @Valid @RequestBody Pets pets) {
		pets.set_id(id);
		repository.save(pets);
		return pets;
	}
	
	@PostMapping
	public Pets createPet(@Valid @RequestBody Pets pets) {
		pets.set_id(ObjectId.get());
		repository.save(pets);
		return pets;
	}
	
	@DeleteMapping("/{id}")
	public String deletePet(@PathVariable ObjectId id) {
		if(repository.findBy_id(id) != null) {
			repository.delete(repository.findBy_id(id));
			return "Deleted!!";
		}
		return "Something went wrong";
	}
}
