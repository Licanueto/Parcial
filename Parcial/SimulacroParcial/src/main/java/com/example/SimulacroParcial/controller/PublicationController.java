package com.example.SimulaproParcial.controller;

import com.example.SimulacroParcial.model.Publication;
import com.example.SimulacroParcial.services.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Publication")
public class PublicationController {

    @Autowired
    PublicationRepository pr;
    
    @GetMapping("")
    public List getAll(){
        return pr.findAll();
    }

    @GetMapping("/{id}")
    public Publication getPublication(@PathVariable Integer id){
        Optional opPub = pr.findById(id);
        if(opPub.isPresent())
            return (Publication)opPub.get();
        else return null;
    }

    @PostMapping("")
    public void addPublications(@RequestBody Publication[] publis){
        for(int i=0;i<publis.length;i++)
            pr.save(publis[i]);
    }

}
