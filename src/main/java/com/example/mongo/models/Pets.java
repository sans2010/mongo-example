package com.example.mongo.models;

import org.springframework.data.annotation.Id;
import org.bson.types.ObjectId;

public class Pets {

	@Id
	public Object _id;
	
	public String name;
	public String species;
	public String breed;
	
	//contructors
	public Pets() {}

	public Pets(Object _id, String name, String species, String breed) {
		super();
		this._id = _id;
		this.name = name;
		this.species = species;
		this.breed = breed;
	}

	public String get_id() {
		return _id.toString();
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}
	
}
