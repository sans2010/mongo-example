package com.example.mongo.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.mongo.models.Pets;

public interface PetRepository extends MongoRepository<Pets, String>{
	//Pets findBy_Id(ObjectId _id);
	Pets findBy_id(ObjectId _id);
}
