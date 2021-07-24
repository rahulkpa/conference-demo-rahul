package com.wellsfargo.conferencedemo.controllers;

import com.wellsfargo.conferencedemo.models.Speaker;
import com.wellsfargo.conferencedemo.models.SpeakerDTO;
import com.wellsfargo.conferencedemo.repositories.SpeakerRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v2/speakers")
public class SpeakerV1Controller {
    @Autowired
    SpeakerRepositories speakerRepositories;

    @GetMapping("{id}")
    public SpeakerDTO getSpeaker(@PathVariable Long id){
        SpeakerDTO speakerDTO = new SpeakerDTO();
        Speaker speaker = speakerRepositories.getById(id);
        speakerDTO.setSpeakerId(speaker.getSpeaker_id());
        speakerDTO.setFirstName(speaker.getFirst_name());
        speakerDTO.setLastName(speaker.getLast_name());
        speakerDTO.setCompany(speaker.getCompany());
        speakerDTO.setSessions(speaker.getSessions());
        speakerDTO.setSpeakerBio(speaker.getSpeaker_bio());
        speakerDTO.setTitle(speaker.getTitle());
        speakerDTO.setSpeakerPhoto(speaker.getSpeaker_photo());
        return  speakerDTO;
    }
}
