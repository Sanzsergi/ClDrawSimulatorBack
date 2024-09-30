package com.championsDraw.cldraw.controller;

import com.championsDraw.cldraw.model.DrawTeams;
import com.championsDraw.cldraw.model.Teams;
import com.championsDraw.cldraw.service.ClDrawService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class ClDrawController {

    @Autowired
    private ClDrawService clDrawService;

    @GetMapping("/getTeams")
    private ResponseEntity<List<Teams>> getTeams() {
        List<Teams> teams = clDrawService.getTeams();
        return ResponseEntity.ok(teams);
    }

    @GetMapping("/getGroupTeams")
    private ResponseEntity<List<Teams>> getTeamsByGroup(@RequestParam("teamNumber") int teamNumber) {
        List<Teams> teams = clDrawService.getTeamsByTeamGroup(teamNumber);
        return ResponseEntity.ok(teams);
    }

    @GetMapping("/getTeamById")
    private ResponseEntity<Optional<Teams>> getTeamById(@RequestParam("teamId") Long id) {
        Optional<Teams> team = clDrawService.getTeamById(id);
        return ResponseEntity.ok(team);
    }

    @GetMapping("/getGroupsByTeamId")
    private ResponseEntity<List<Teams>> getGroupsByTeamId(@RequestParam("teamId") Long id, @RequestParam("teamGroupNumber") int teamNumber) {
        List<Teams> teams = clDrawService.getGroupsByTeamId(id, teamNumber);
        return ResponseEntity.ok(teams);
    }

    @GetMapping("/getChampionsDraw")
    private ResponseEntity<String> getChampionsDraw(){
        List<Teams> teams = clDrawService.getTeams();
        JsonObject jsonTeamDraw = new JsonObject();
        List<DrawTeams> drawTeams = new ArrayList<>();

        // All Teams
        for (Teams team : teams) {
            ArrayList<String> teamsDraw = new ArrayList<>();
            ArrayList<String> teamCountries = new ArrayList<>();

            //All Groups
            for (int j = 1; j < 5; j++) {
                List<Teams> teamsGroups = clDrawService.getGroupsByTeamId(team.getId(), j);
                ArrayList<String> duplicated = new ArrayList<>();

                for (int k = 0; k < 2; k++) {
                    // Check Max 2 Countries
                    if (!duplicated.isEmpty()) {
                        for (String duplied : duplicated) {
                            teamsGroups.removeIf(teamsGroup -> teamsGroup.getCountry().equals(duplied));
                        }
                    }

                    // Generate randomNumber by teamGroup size
                    Random randomNumber = new Random();
                    int randomIndex = randomNumber.nextInt(teamsGroups.size());
                    Teams randomTeam = teamsGroups.get(randomIndex);

                    // Get country name from randomTeam to check if country already exists in teams
                    String country = randomTeam.getCountry();
                    teamCountries.add(country);

                    // Get randomTeam to teamsDraw
                    teamsDraw.add(randomTeam.getTeamname());

                    //Remove random team to avoid collisions
                    teamsGroups.remove(randomTeam);

                    duplicated = findStringsWithMinOccurrences(teamCountries);
                }
            }

//            jsonTeamDraw.add(team.getTeamname(), teamsDraw);
            drawTeams.add(new DrawTeams(team.getTeamname(), teamsDraw));
        }

        Gson gson = new Gson();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(gson.toJson(drawTeams));
    }

    public static ArrayList<String> findStringsWithMinOccurrences(ArrayList<String> list) {
        HashMap<String, Integer> frequencyMap = new HashMap<>();

        // Count occurrences of each string
        for (String s : list) {
            frequencyMap.put(s, frequencyMap.getOrDefault(s, 0) + 1);
        }
        ArrayList<String> result = new ArrayList<>();

        // Find strings that occur at least minOccurrences times
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() >= 2) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

}
