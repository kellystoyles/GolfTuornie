package com.keyin.domain.golfmember;

import com.keyin.domain.golftournament.Tournament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;


@Service
    public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public GolfMember createGolfMember(GolfMember member) {
        return memberRepository.save(member);
    }

    public List<GolfMember> createGolfMembers(List<GolfMember> members) {
        return (List<GolfMember>) memberRepository.saveAll(members);
    }

    public List<GolfMember> findAllGolfMembers() {
        return (List<GolfMember>) memberRepository.findAll();
    }

    public List<GolfMember> searchByName(String name) {
        return memberRepository.findByNameContaining(name);
    }

    public List<GolfMember> searchByPhone(String phone) {
        return memberRepository.findByPhone(phone);
    }

    public List<GolfMember> findByStartDate(LocalDate date) {
        return memberRepository.findByStartDate(date);
    }

    public GolfMember findById(Long id) {
        return memberRepository.findById(id).orElse(null);
    }

    public GolfMember updateGolfMember(GolfMember updatedGolfMember) {
        GolfMember existingMember = findById(updatedGolfMember.getId());

        if (existingMember != null) {
            if (updatedGolfMember.getAddress() != null) {
                existingMember.setAddress(updatedGolfMember.getAddress());
            }
            if (updatedGolfMember.getName() != null) {
                existingMember.setName(updatedGolfMember.getName());
            }
            if (updatedGolfMember.getEmail() != null) {
                existingMember.setEmail(updatedGolfMember.getEmail());
            }
            if (updatedGolfMember.getPhone() != null) {
                existingMember.setPhone(updatedGolfMember.getPhone());
            }
            if (updatedGolfMember.getStartDate() != null) {
                existingMember.setStartDate(updatedGolfMember.getStartDate());
            }
            if (updatedGolfMember.getMembershipDuration() != null) {
                existingMember.setMembershipDuration(updatedGolfMember.getMembershipDuration());
            }
            return memberRepository.save(existingMember);
        }
        return null;
    }

    public void deleteGolfMember(Long id) {
        GolfMember member = findById(id);
        if (member != null) {
            // Remove the member from all associated tournaments
            for (Tournament tournament : member.getTournaments()) {
                tournament.getParticipatingMembers().remove(member);
            }
            member.getTournaments().clear();
            memberRepository.deleteById(id);
        }
    }
}

