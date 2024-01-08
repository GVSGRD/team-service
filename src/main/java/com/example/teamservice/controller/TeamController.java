package com.example.teamservice.controller;

import com.example.teamservice.entity.Team;
import com.example.teamservice.service.interfaces.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/team")
@CrossOrigin("http://localhost:3000")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @PostMapping("/create")
    public ResponseEntity<Team> createTeam(@RequestBody Team team) {
        Team resp = teamService.createTeam(team);
        return new ResponseEntity<Team>(resp, HttpStatus.CREATED);
    }

    @GetMapping("/{teamId}")
    public ResponseEntity<Team> getTeamById(@PathVariable Long teamId) {
        Team resp = teamService.findTeamById(teamId);
        return new ResponseEntity<Team>(resp, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Team>> getAllTeams() {
        List<Team> resp = teamService.findAllTeams();
        return new ResponseEntity<List<Team>>(resp, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Team> updateTeam(@RequestBody Team team) {
        Team resp = teamService.updateTeam(team);
        return new ResponseEntity<Team>(resp, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{teamId}")
    public ResponseEntity<Long> deleteTeam(@PathVariable Long teamId) {
        teamService.deleteTeam(teamId);
        return new ResponseEntity<Long>(teamId, HttpStatus.NO_CONTENT);
    }
}

