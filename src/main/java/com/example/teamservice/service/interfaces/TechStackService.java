package com.example.teamservice.service.interfaces;

import com.example.teamservice.entity.TechStack;

import java.util.List;

public interface TechStackService {

    TechStack createTechStack(TechStack techStack);

    TechStack findTechStackById(long techStackId);

    List<TechStack> findAllTechStacks();

    TechStack updateTechStack(TechStack techStack);

    void deleteTechStack(long techStackId);

    List<TechStack> getTechStacksByTeamId(long teamId);
}


