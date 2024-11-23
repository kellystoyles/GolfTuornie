package com.keyin.domain.golfmember;

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

    public List <GolfMember> searchByName(String name) {
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
        GolfMember golfMemberToUpdate = findById(updatedGolfMember.getId());

        if (golfMemberToUpdate != null) {
            golfMemberToUpdate.setName(updatedGolfMember.getName());
            golfMemberToUpdate.setAddress(updatedGolfMember.getAddress());
            golfMemberToUpdate.setEmail(updatedGolfMember.getEmail());
            golfMemberToUpdate.setPhone(updatedGolfMember.getPhone());
            golfMemberToUpdate.setStartDate(updatedGolfMember.getStartDate());
            golfMemberToUpdate.setMembershipDuration(updatedGolfMember.getMembershipDuration());
            return memberRepository.save(golfMemberToUpdate);
        }
        return null;
    }
    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }
}

