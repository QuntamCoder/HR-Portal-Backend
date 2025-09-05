package com.HR_Management_backend.service;

import com.HR_Management_backend.entity.Team;
import com.HR_Management_backend.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Optional<Team> getTeamById(Integer id) {
        return teamRepository.findById(id);
    }

    public Team updateTeam(Integer id, Team updatedTeam) {
        return teamRepository.findById(id)
                .map(team -> {
                    updatedTeam.setId(id);
                    return teamRepository.save(updatedTeam);
                })
                .orElseThrow(() -> new RuntimeException("Team not found with id " + id));
    }

    public void deleteTeam(Integer id) {
        teamRepository.deleteById(id);
    }
}