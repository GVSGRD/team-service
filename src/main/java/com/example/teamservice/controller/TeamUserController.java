package com.example.teamservice.controller;

import com.example.teamservice.entity.TeamUser;
import com.example.teamservice.service.interfaces.TeamUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team-user")
public class TeamUserController {
    @Autowired
    private TeamUserService teamUserService;

    @PostMapping("/create")
    public ResponseEntity<TeamUser> createTeamUser(@RequestBody TeamUser teamUser) {
        TeamUser resp = teamUserService.createTeamUser(teamUser);
        return new ResponseEntity<>(resp, HttpStatus.CREATED);
    }

    @GetMapping("/{teamUserId}")
    public ResponseEntity<TeamUser> getTeamUserById(@PathVariable Long teamUserId) {
        TeamUser resp = teamUserService.findTeamUserById(teamUserId);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<TeamUser>> getAllTeamUsers() {
        List<TeamUser> resp = teamUserService.findAllTeamUsers();
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<TeamUser> updateTeamUser(@RequestBody TeamUser teamUser) {
        TeamUser resp = teamUserService.updateTeamUser(teamUser);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{teamUserId}")
    public ResponseEntity<Long> deleteTeamUser(@PathVariable Long teamUserId) {
        teamUserService.deleteTeamUser(teamUserId);
        return new ResponseEntity<>(teamUserId, HttpStatus.NO_CONTENT);
    }

    @GetMapping("team/{teamId}")
    public ResponseEntity<List<TeamUser>> getSkillsByUserId(@PathVariable("teamId") Long teamId){

        List<TeamUser> resp = teamUserService.getUsersByTeamId(teamId);
        return new ResponseEntity<List<TeamUser>>(resp, HttpStatus.OK);

    }

}

