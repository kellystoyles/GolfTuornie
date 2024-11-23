package com.keyin.domain.golftournament;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface TournamentRepository extends CrudRepository<Tournament, Long> {

    List <Tournament> findByName(String name);

    List <Tournament>findByLocation(String location);

    List <Tournament>findByStartDate(LocalDate startDate);

    List<Tournament>findAll();




}

