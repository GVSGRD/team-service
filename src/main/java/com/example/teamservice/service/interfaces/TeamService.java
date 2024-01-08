package com.example.teamservice.service.interfaces;

import com.example.teamservice.entity.Team;

import java.util.List;

public interface TeamService {
    Team createTeam(Team team);
    Team findTeamById(Long teamId);
    List<Team> findAllTeams();
    Team updateTeam(Team team);
    void deleteTeam(Long teamId);
}
