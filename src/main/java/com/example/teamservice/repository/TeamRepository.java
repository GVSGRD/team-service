package com.example.teamservice.repository;

import com.example.teamservice.entity.Team;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface TeamRepository extends JpaRepository<Team, Long> {

}
