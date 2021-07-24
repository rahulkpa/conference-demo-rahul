package com.wellsfargo.conferencedemo.controllers;

import com.wellsfargo.conferencedemo.models.Session;
import com.wellsfargo.conferencedemo.models.SessionDTO;
import com.wellsfargo.conferencedemo.repositories.SessionRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v2/sessions")
public class SessionV1Controller {
    @Autowired
    SessionRepositories sessionRepositories;

    @GetMapping("{id}")
    public SessionDTO getSession(@PathVariable Long id){
        List<SessionDTO> sessionDTOList = new ArrayList<>();
        SessionDTO sessionDTO = new SessionDTO();
        Session session = sessionRepositories.getById(id);
        sessionDTO.setSessionId(session.getSession_id());
        sessionDTO.setSessionName(session.getSession_name());
        sessionDTO.setSessionDescription(session.getSession_description());
        sessionDTO.setSessionLength(session.getSession_length());
        sessionDTO.setSpeakers(session.getSpeakers());
        return sessionDTO;
    }
}
