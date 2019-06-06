package com.example.SimulacroParcial.controller;

import com.example.SimulacroParcial.model.User;
import com.example.SimulacroParcial.services.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    UserRepository ur;

    @GetMapping("")
    public List getAll(){
        return ur.findAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Integer id){
        Optional opUser = ur.findById(id);
        if(opUser.isPresent())
            return (User)opUser.get();
        else return null;
    }

    @PostMapping("")
    public void addUser(@RequestBody User user, @RequestHeader("user-agent") String browser){
        user.setBrowser(browser);
        ur.save(user);
    }

    @PutMapping("/{id}")
    public void modifyUser(@RequestBody User u, @PathVariable("id") Integer id){
        u.setId(id);
        ur.save(u);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        ur.deleteById(id);
    }



}
