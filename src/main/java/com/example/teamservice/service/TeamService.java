package com.example.teamservice.service;

import com.example.teamservice.entity.Team;
import com.example.teamservice.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService implements com.example.teamservice.service.interfaces.TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public Team findTeamById(Long teamId) {
        return teamRepository.findById(teamId).orElse(null);
    }

    @Override
    public List<Team> findAllTeams() {
        return teamRepository.findAll();
    }

    @Override
    public Team updateTeam(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public void deleteTeam(Long teamId) {
        teamRepository.deleteById(teamId);
    }
}
