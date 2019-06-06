package com.example.SimulacroParcial.controller;

import com.example.SimulacroParcial.model.Comment;
import com.example.SimulacroParcial.services.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Comment")
public class CommentController {

    @Autowired
    CommentRepository cr;
    
    @GetMapping("")
    public List getAll(){
        return cr.findAll();
    }

    @GetMapping("/{id}")
    public Comment getComment(@PathVariable Integer id){
        Optional opComm = cr.findById(id);
        if(opComm.isPresent())
            return (Comment)opComm.get();
        else return null;
    }

    @PostMapping("")
    public void addComment(@RequestBody Comment comm){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        comm.setDate(formatter.format(Date.valueOf(LocalDate.now())));
        cr.save(comm);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        cr.deleteById(id);
    }

    @Scheduled(fixedDelay = prop.getProperty("comments.scheduledDelete")) //ejecuta el metodo cada la cantidad de tiempo que se determine (en formato Cron)
    private void deteleComments(){
        Date fiveMinsAgo = Date.valueOf(LocalDate.now().minus(Duration.ofMinutes(5)));
        cr.deleteInBatch(cr.findAll()
                .stream()
                .filter(vote -> vote.getDate().before(fiveMinsAgo))
                .collect(Collectors.toList()));
    }



}
