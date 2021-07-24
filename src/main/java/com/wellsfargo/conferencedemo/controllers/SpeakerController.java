package com.wellsfargo.conferencedemo.controllers;

import com.wellsfargo.conferencedemo.models.Session;
import com.wellsfargo.conferencedemo.models.Speaker;
import com.wellsfargo.conferencedemo.repositories.SessionRepositories;
import com.wellsfargo.conferencedemo.repositories.SpeakerRepositories;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakerController {
    @Autowired
    SpeakerRepositories speakerRepositories;

    @GetMapping
    public List<Speaker> getAllSpeakers(){
        return speakerRepositories.findAll();
    }

    @GetMapping("{id}")
    public Speaker getSpeaker(@PathVariable Long id){
        return speakerRepositories.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Speaker saveSpeaker(@RequestBody Speaker speaker){
        return speakerRepositories.saveAndFlush(speaker);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteSpeaker(@PathVariable Long id){
        speakerRepositories.deleteById(id);
    }

    @RequestMapping(value="{id}",method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public Speaker updateSpeaker(@PathVariable Long id, @RequestBody Speaker inputSpeaker){
        Speaker speaker = speakerRepositories.getById(id);
        BeanUtils.copyProperties(inputSpeaker,speaker, "session_id");
        return speakerRepositories.saveAndFlush(speaker);
    }
}
