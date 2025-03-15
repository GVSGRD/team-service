package com.example.teamservice.controller;

import com.example.teamservice.entity.TechStack;
import com.example.teamservice.service.interfaces.TechStackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/techstack")
public class TechStackController {

    @Autowired
    private TechStackService techStackService;

    @PostMapping("/create")
    public ResponseEntity<TechStack> createTechStack(@RequestBody TechStack techStack) {
        TechStack resp = techStackService.createTechStack(techStack);
        return new ResponseEntity<>(resp, HttpStatus.CREATED);
    }

    @GetMapping("/{techStackId}")
    public ResponseEntity<TechStack> getTechStackById(@PathVariable int techStackId) {
        TechStack resp = techStackService.findTechStackById(techStackId);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<TechStack>> getAllTechStacks() {
        List<TechStack> resp = techStackService.findAllTechStacks();
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<TechStack> updateTechStack(@RequestBody TechStack techStack) {
        TechStack resp = techStackService.updateTechStack(techStack);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{techStackId}")
    public ResponseEntity<Integer> deleteTechStack(@PathVariable int techStackId) {
        techStackService.deleteTechStack(techStackId);
        return new ResponseEntity<>(techStackId, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/team/{teamId}")
    public ResponseEntity<List<TechStack>> getTechStacksByTeamId(@PathVariable("teamId") int teamId) {
        List<TechStack> resp = techStackService.getTechStacksByTeamId(teamId);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
}
