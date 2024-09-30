package com.championsDraw.cldraw.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Entity
@Data
@Getter
public class DrawTeams {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String teamname;
    private List<String> rivals;

    public DrawTeams(String teamname, List<String> rivals) {
        this.teamname = teamname;
        this.rivals = rivals;
    }
}
