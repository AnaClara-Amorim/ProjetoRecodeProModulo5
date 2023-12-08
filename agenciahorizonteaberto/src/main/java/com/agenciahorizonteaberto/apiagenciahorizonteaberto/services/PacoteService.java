package com.agenciahorizonteaberto.apiagenciahorizonteaberto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.agenciahorizonteaberto.apiagenciahorizonteaberto.models.PacoteModel;
import com.agenciahorizonteaberto.apiagenciahorizonteaberto.repositories.IPacoteRepositories;

@Service
public class PacoteService {
    
    private final IPacoteRepositories pacoteRepositories;
    
    public PacoteService (IPacoteRepositories pacoteRepositories){
        this.pacoteRepositories = pacoteRepositories;
    }

    public PacoteModel createPacote(PacoteModel pacote) {
        if (pacote == null) {
            throw new IllegalArgumentException("Pacote não existe!");
        }

        return pacoteRepositories.save(pacote);
    }

    public List<PacoteModel> listPacote(){
        return pacoteRepositories.findAll();
    }

    public PacoteModel updatePacote (PacoteModel pacoteUpdated){
        if (pacoteUpdated == null || pacoteUpdated.getId() == null) {
            throw new IllegalArgumentException("Pacote não encontrado!");
        }
        Optional<PacoteModel> existingPacote = pacoteRepositories.findById(pacoteUpdated.getId());

     if (existingPacote.isEmpty()){
        throw new IllegalArgumentException("Pacote não encontrado! Tente outra vez.");
     }
     return pacoteRepositories.save(pacoteUpdated);
    }       

    public void delete (String id ) {
        if (id == null) {
            throw new IllegalArgumentException("Id não encontrado!");
        }
        pacoteRepositories.deleteById(id);
    }

}
