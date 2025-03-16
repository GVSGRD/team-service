package com.example.teamservice.service.interfaces;

import com.example.teamservice.entity.TeamUser;

import java.util.List;

public interface TeamUserService {
    TeamUser createTeamUser(TeamUser teamUser);
    TeamUser findTeamUserById(Long teamUserId);
    List<TeamUser> findAllTeamUsers();
    TeamUser updateTeamUser(TeamUser teamUser);
    int acceptTeamUser(Long requestId);
    int rejectTeamUser(Long requestId);
    void deleteTeamUser(Long teamUserId);
    List<TeamUser> findByUserId(Long userId);
    List<TeamUser> findByTeamId(Long teamId);
    List<TeamUser> findRequestsByUserID(Long userId);
}

