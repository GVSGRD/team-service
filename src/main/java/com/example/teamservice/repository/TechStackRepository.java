package com.example.teamservice.repository;

import com.example.teamservice.entity.TechStack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TechStackRepository extends JpaRepository<TechStack, Long> {
    List<TechStack> findByTeamId(Long teamId);
}

