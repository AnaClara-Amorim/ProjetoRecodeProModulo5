package com.agenciahorizonteaberto.apiagenciahorizonteaberto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.agenciahorizonteaberto.apiagenciahorizonteaberto.models.UserModel;
import com.agenciahorizonteaberto.apiagenciahorizonteaberto.repositories.IUserRepositories;

@Service
public class UserService {
    
    private final IUserRepositories userRepositories; 

    public UserService(IUserRepositories userRepositories) { //Gerado com o gerador de construtor
        this.userRepositories = userRepositories;
    }

    public UserModel createUser(UserModel user){ // Método para criar um usuário, vai receber um usuário
        if (user == null) {
            throw new IllegalArgumentException("Usuário não existe!");
        } 
        return userRepositories.save(user);
        // Precisa criar userRepositories
    }

    public List<UserModel> listUsers(){
        return userRepositories.findAll();
    }

    public UserModel updateUser(UserModel userUpdated){
        if (userUpdated == null || userUpdated.getId() == null){
            throw new IllegalArgumentException("Usuário não encontrado!");
        }
        Optional<UserModel> existingUser = userRepositories.findById(userUpdated.getId()); // Criação de variável que vai receber um usuário do banco 

        if (existingUser.isEmpty()){
            throw new IllegalArgumentException("Usuário não encontrado! Tente outra vez.");
        }

        return userRepositories.save(userUpdated);
    }

    public void delete(String id){
        if(id == null){
            throw new IllegalArgumentException("Id não encontrado!");
        }
        userRepositories.deleteById(id);
    }



    
}
