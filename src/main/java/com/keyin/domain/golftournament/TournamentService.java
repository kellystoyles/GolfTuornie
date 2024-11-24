package com.keyin.domain.golftournament;

import com.keyin.domain.golfmember.MemberService;
import com.keyin.domain.golfmember.GolfMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
    public class TournamentService {
    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private MemberService memberService;  // Add this line


    public TournamentService(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }

    public Tournament createTournament(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }


    public List<Tournament> findAll() {
        return tournamentRepository.findAll();
    }

    public List<Tournament> findAllTournaments() {
        return tournamentRepository.findAll();
    }

    public List<Tournament> findByName(String name){
        return tournamentRepository.findByName(name);
    }

    public List<Tournament> findByLocation(String location){
        return tournamentRepository.findByLocation(location);
    }

    public List<Tournament> findByStartDate(LocalDate startdate){
        return tournamentRepository.findByStartDate(startdate);
    }

  //  public Tournament findById(Long id) {
  //      return tournamentRepository.findById(id).orElse(null);
 //   }

    public Tournament findById(Long id) {
        Tournament tournament = tournamentRepository.findById(id).orElse(null);
        if (tournament == null) {
            System.out.println("Tournament with id " + id + " not found");
        } else {
            System.out.println("Found tournament: " + tournament.getName());
        }
        return tournament;
    }

    public Tournament updateTournament(Tournament updatedTournament) {
        Tournament tournamentToUpdate = findById(updatedTournament.getId());

        if (tournamentToUpdate != null) {
            tournamentToUpdate.setName(updatedTournament.getName());
            tournamentToUpdate.setStartDate(updatedTournament.getStartDate());
            tournamentToUpdate.setLocation(updatedTournament.getLocation());
            tournamentToUpdate.setEndDate(updatedTournament.getEndDate());
            tournamentToUpdate.setEntryFee(updatedTournament.getEntryFee());
            tournamentToUpdate.setCashPrizeAmount(updatedTournament.getCashPrizeAmount());
            return tournamentRepository.save(tournamentToUpdate);
        }
        return null;
    }

    public Tournament addMemberToTournament(Long tournamentId, Long memberId) {
        Tournament tournament = this.findById(tournamentId);
        GolfMember member = memberService.findById(memberId);
        if (tournament == null || member == null) {
            throw new RuntimeException("Tournament or Member not found");
        }
        tournament.getParticipatingMembers().add(member);
        return tournamentRepository.save(tournament);
    }

    public List<Tournament> createTournaments(List<Tournament> tournaments) {
        return (List<Tournament>) tournamentRepository.saveAll(tournaments);
    }

    public void deleteTournament(Long id) {
        tournamentRepository.deleteById(id);
    }

}

