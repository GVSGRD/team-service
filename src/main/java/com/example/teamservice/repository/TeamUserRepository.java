package com.example.teamservice.repository;

import com.example.teamservice.entity.TeamUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamUserRepository extends JpaRepository<TeamUser, Long> {
    List<TeamUser> findByTeamId(Long teamId);
}

