package com.wellsfargo.conferencedemo.repositories;

import com.wellsfargo.conferencedemo.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepositories extends JpaRepository<Speaker, Long> {
}
