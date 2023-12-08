package com.agenciahorizonteaberto.apiagenciahorizonteaberto.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.agenciahorizonteaberto.apiagenciahorizonteaberto.models.UserModel;

public interface IUserRepositories extends MongoRepository<UserModel, String>{
    
}
