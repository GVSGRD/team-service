package com.example.teamservice.service;

import com.example.teamservice.entity.TeamUser;
import com.example.teamservice.repository.TeamUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class TeamUserService implements com.example.teamservice.service.interfaces.TeamUserService {
    @Autowired
    private TeamUserRepository teamUserRepository;

    public TeamUser createTeamUser(TeamUser teamUser) {
        return teamUserRepository.save(teamUser);
    }

    public TeamUser findTeamUserById(Long teamUserId) {
        return teamUserRepository.findById(teamUserId).orElse(null);
    }

    public List<TeamUser> findAllTeamUsers() {
        return teamUserRepository.findAll();
    }

    public TeamUser updateTeamUser(TeamUser teamUser) {
        return teamUserRepository.save(teamUser);
    }

    public void deleteTeamUser(Long teamUserId) {
        teamUserRepository.deleteById(teamUserId);
    }

    @Override
    public List<TeamUser> findByUserId(Long userId) {
        return teamUserRepository.findByUserIdAndStatus(userId);
    }

    @Override
    public List<TeamUser> findByTeamId(Long teamId) {
        return teamUserRepository.findByTeamIdAndStatus(teamId);
    }

    @Override
    public List<TeamUser> findRequestsByUserID(Long userId) {
        return teamUserRepository.findRequestsByUserID(userId);
    }

    @Override
    public TeamUser findByUserIdAndTeamId(Long userId, Long teamId){
        return teamUserRepository.findByUserIdAndTeamId(userId, teamId);
    }

    @Transactional
    public int acceptTeamUser(Long requestId) {
        return teamUserRepository.acceptTeamUser(requestId);
    }

    @Transactional
    public int rejectTeamUser(Long requestId) {
        return teamUserRepository.rejectTeamUser(requestId);
    }
}

