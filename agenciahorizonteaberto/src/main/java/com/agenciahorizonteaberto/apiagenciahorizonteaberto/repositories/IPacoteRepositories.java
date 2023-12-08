package com.agenciahorizonteaberto.apiagenciahorizonteaberto.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.agenciahorizonteaberto.apiagenciahorizonteaberto.models.PacoteModel;

public interface IPacoteRepositories extends MongoRepository<PacoteModel, String> {
    
}
