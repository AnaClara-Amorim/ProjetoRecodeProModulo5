package com.agenciahorizonteaberto.apiagenciahorizonteaberto.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.agenciahorizonteaberto.apiagenciahorizonteaberto.models.PacoteModel;
import com.agenciahorizonteaberto.apiagenciahorizonteaberto.services.PacoteService;

@RestController
@ResquestMapping("/pacote")
public class PacoteController {
    
    private final PacoteService pacoteService;

    public PacoteController(PacoteService pacoteService) {
        this.pacoteService = pacoteService;
    }

    @PostMapping   
    public ResponseEntity<PacoteModel> createPacote (@RequestBody PacoteModel pacote){
        PacoteModel createdPacote = pacoteService.createPacote(pacote);
        return new ResponseEntity<>(createdPacote, HttpStatus.CREATED);
    }

    @GetMapping     
    public ResponseEntity<List<PacoteModel>> getAllUsers(){
        List<PacoteModel> pacote = pacoteService.listPacote();
        return new ResponseEntity<>(pacote, HttpStatus.OK);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deletePacote(@PathVariable("id") String id){
        pacoteService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);        
    }

}
