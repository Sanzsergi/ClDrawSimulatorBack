package com.championsDraw.cldraw.repository;

import com.championsDraw.cldraw.model.Teams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClDrawRepository extends JpaRepository<Teams, Long> {

    List<Teams> findByTeamgroup(int teamgroup);

    @Query(
            value = "SELECT * FROM teams t WHERE t.teamgroup = :group AND NOT t.country = :country",
            nativeQuery = true)
    List<Teams> findTeamsByGroupAndNotCountry(int group, String country);

}
