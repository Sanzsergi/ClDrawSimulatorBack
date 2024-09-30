package com.championsDraw.cldraw.startup;

import com.championsDraw.cldraw.model.Teams;
import com.championsDraw.cldraw.repository.ClDrawRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StartupConfig {

    @Autowired
    private ClDrawRepository clDrawRepository;

    @Bean
    public CommandLineRunner insertInitialData() {
        return args -> {
            clDrawRepository.save(new Teams(1L, "Real Madrid CF", "ESP", 1));
            clDrawRepository.save(new Teams(2L, "Manchester City", "ENG", 1));
            clDrawRepository.save(new Teams(3L, "FC Bayern München", "GER", 1));
            clDrawRepository.save(new Teams(4L, "Paris Saint-Germain CF", "FRA", 1));
            clDrawRepository.save(new Teams(5L, "Liverpool FC", "ENG", 1));
            clDrawRepository.save(new Teams(6L, "FC Internazionale Milano", "ITA", 1));
            clDrawRepository.save(new Teams(7L, "Borussia Dortmund", "GER", 1));
            clDrawRepository.save(new Teams(8L, "RB Leipzig", "GER", 1));
            clDrawRepository.save(new Teams(9L, "FC Barcelona", "ESP", 1));
            clDrawRepository.save(new Teams(10L, "Bayer 04 Leverkusen", "GER", 2));
            clDrawRepository.save(new Teams(11L, "Atlético de Madrid", "ESP", 2));
            clDrawRepository.save(new Teams(12L, "Atalanta BC", "ITA", 2));
            clDrawRepository.save(new Teams(13L, "Juventus", "ITA", 2));
            clDrawRepository.save(new Teams(14L, "SL Benfica", "POR", 2));
            clDrawRepository.save(new Teams(15L, "Arsenal FC", "ENG", 2));
            clDrawRepository.save(new Teams(16L, "Club Brugge KV", "BEL", 2));
            clDrawRepository.save(new Teams(17L, "FC Shakhtar Donetsk", "UKR", 2));
            clDrawRepository.save(new Teams(18L, "AC Milan", "ITA", 2));
            clDrawRepository.save(new Teams(19L, "Feyenoord", "NED", 3));
            clDrawRepository.save(new Teams(20L, "Sporting Clube de Portugal", "POR", 3));
            clDrawRepository.save(new Teams(21L, "PSV Eindhoven", "NED", 3));
            clDrawRepository.save(new Teams(22L, "GNK Dinamo", "CRO", 3));
            clDrawRepository.save(new Teams(23L, "FC Salzburg", "AUT", 3));
            clDrawRepository.save(new Teams(24L, "LOSC Lille", "FRA", 3));
            clDrawRepository.save(new Teams(25L, "FK Crvena Zvezda", "SRB", 3));
            clDrawRepository.save(new Teams(26L, "BSC Young Boys", "SUI", 3));
            clDrawRepository.save(new Teams(27L, "Celtic FC", "SCO", 3));
            clDrawRepository.save(new Teams(28L, "ŠK Slovan Bratislava", "SVK", 4));
            clDrawRepository.save(new Teams(29L, "AS Monaco", "FRA", 4));
            clDrawRepository.save(new Teams(30L, "AC Sparta Praha", "CZE", 4));
            clDrawRepository.save(new Teams(31L, "Aston Villa FC", "ENG", 4));
            clDrawRepository.save(new Teams(32L, "Bologna FC 1909", "ITA", 4));
            clDrawRepository.save(new Teams(33L, "Girona FC", "ESP", 4));
            clDrawRepository.save(new Teams(34L, "VfB Stuttgart", "GER", 4));
            clDrawRepository.save(new Teams(35L, "SK Sturm Graz", "AUT", 4));
            clDrawRepository.save(new Teams(36L, "Stade Brestois 29", "FRA", 4));
        };
    }
}