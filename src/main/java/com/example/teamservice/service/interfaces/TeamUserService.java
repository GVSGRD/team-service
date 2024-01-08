package com.example.teamservice.service.interfaces;

import com.example.teamservice.entity.TeamUser;

import java.util.List;

public interface TeamUserService {
    TeamUser createTeamUser(TeamUser teamUser);
    TeamUser findTeamUserById(Long teamUserId);
    List<TeamUser> findAllTeamUsers();
    TeamUser updateTeamUser(TeamUser teamUser);
    void deleteTeamUser(Long teamUserId);
    List<TeamUser> getUsersByTeamId(Long teamId);
}

