package com.example.teamservice.service;

import com.example.teamservice.entity.TechStack;
import com.example.teamservice.repository.TechStackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechStackService implements com.example.teamservice.service.interfaces.TechStackService {

    @Autowired
    private TechStackRepository techStackRepository;

    @Override
    public TechStack createTechStack(TechStack techStack) {
        return techStackRepository.save(techStack);
    }

    @Override
    public TechStack findTechStackById(long techStackId) {
        return techStackRepository.findById(techStackId).orElse(null);
    }

    @Override
    public List<TechStack> findAllTechStacks() {
        return techStackRepository.findAll();
    }

    @Override
    public TechStack updateTechStack(TechStack techStack) {
        return techStackRepository.save(techStack);
    }

    @Override
    public void deleteTechStack(long techStackId) {
        techStackRepository.deleteById(techStackId);
    }

    @Override
    public List<TechStack> getTechStacksByTeamId(long teamId) {
        return techStackRepository.findByTeamId(teamId);
    }
}
