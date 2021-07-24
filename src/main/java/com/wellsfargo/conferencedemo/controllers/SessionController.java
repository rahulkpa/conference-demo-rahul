package com.wellsfargo.conferencedemo.controllers;

import com.wellsfargo.conferencedemo.models.Session;
import com.wellsfargo.conferencedemo.repositories.SessionRepositories;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionController {

    @Autowired
    SessionRepositories sessionRepositories;

    @GetMapping
    public List<Session> getAllSessions(){
        return sessionRepositories.findAll();
    }

    @GetMapping("{id}")
    public Session getSession(@PathVariable Long id){
        return sessionRepositories.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Session saveSession(@RequestBody Session session){
        return sessionRepositories.saveAndFlush(session);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteSession(@PathVariable Long id){
        sessionRepositories.deleteById(id);
    }

    @RequestMapping(value="{id}",method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public Session updateSession(@PathVariable Long id, @RequestBody Session inputSession){
        Session session = sessionRepositories.getById(id);
        BeanUtils.copyProperties(inputSession,session, "session_id");
        return sessionRepositories.saveAndFlush(session);
    }
}
