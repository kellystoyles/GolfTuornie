package com.keyin.domain.golftournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class TournamentController {
    @Autowired
    private TournamentService tournamentService;

    @GetMapping("/Tournament/{id}")
    public Tournament getByID(@PathVariable Long id) {
        return tournamentService.findById(id);
    }

    @GetMapping("/Tournament/name/{name}")
    public List<Tournament> getByName(@PathVariable String name) {
        return tournamentService.findByName(name);
    }

    @GetMapping("/Tournament/location/{location}")
    public List <Tournament> getByLocation( @PathVariable String location) {
        return tournamentService.findByLocation(location);
    }

    @GetMapping("/Tournament")
    public List<Tournament> findAllTournaments() {
        return tournamentService.findAllTournaments();
    }


    @PutMapping("/Tournament/{id}")
    public Tournament updateTournament(@RequestBody Tournament updatedTournament, @PathVariable long id) {
        return tournamentService.updateTournament(updatedTournament);
    }

    @PostMapping("/Tournament")
    public Tournament createTournament(@RequestBody Tournament newTournament) {
        return tournamentService.createTournament(newTournament);
    }

    @PostMapping("/Tournament/bulk")
    public List<Tournament> createTournaments(@RequestBody List<Tournament> newTournaments) {
        return tournamentService.createTournaments(newTournaments);
    }

    @PostMapping("/Tournament/{tournamentId}/addMember/{memberId}")
    public Tournament addMemberToTournament(@PathVariable Long tournamentId, @PathVariable Long memberId) {
        return tournamentService.addMemberToTournament(tournamentId, memberId);
    }
    @DeleteMapping("/Tournament/{id}")
    public void deleteTournament(@PathVariable Long id) {
        tournamentService.deleteTournament(id);
    }



    }



