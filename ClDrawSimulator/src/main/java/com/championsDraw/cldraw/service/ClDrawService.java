package com.championsDraw.cldraw.service;

import com.championsDraw.cldraw.model.Teams;
import com.championsDraw.cldraw.repository.ClDrawRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClDrawService {

    @Autowired
    private ClDrawRepository clDrawRepository;

    public List<Teams> getTeams() {
        List<Teams> teams = clDrawRepository.findAll();
        return teams;
    }

    public List<Teams> getTeamsByTeamGroup(int teamNumber){
        List<Teams> teams = clDrawRepository.findByTeamgroup(teamNumber);
        return teams;
    }

    public Optional<Teams> getTeamById(Long id){
        Optional<Teams> team = clDrawRepository.findById(id);
        return team;
    }

    public List<Teams> getGroupsByTeamId(Long id, int teamgroup){
        Optional<Teams> team = clDrawRepository.findById(id);
        if(team.isPresent()){
            String country = team.get().getCountry();
            return clDrawRepository.findTeamsByGroupAndNotCountry(teamgroup, country);
        } else {
            throw new IllegalArgumentException();
        }
    }
}
