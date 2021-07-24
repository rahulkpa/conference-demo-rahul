package com.wellsfargo.conferencedemo.repositories;

import com.wellsfargo.conferencedemo.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepositories extends JpaRepository<Session,Long> {
}
