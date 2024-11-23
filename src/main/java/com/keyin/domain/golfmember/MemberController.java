package com.keyin.domain.golfmember;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/GolfMember/name/{name}")
    public List<GolfMember> getByName(@PathVariable String name) {
        System.out.println("Received request for name: " + name);
        return memberService.searchByName(name);
    }

    @GetMapping("/GolfMember/id/{id}")
    public GolfMember getByID(@PathVariable Long id) {
        return memberService.findById(id);
    }

    @GetMapping("/GolfMember/date/{startDate}")
    public List<GolfMember> getByStartDate(@PathVariable LocalDate date) {
        return memberService.findByStartDate(date);
    }

    @GetMapping("/GolfMember/phone/{phone}")
    public List<GolfMember> getByPhone(@PathVariable String phone) {
        return memberService.searchByPhone(phone);
    }

    @PostMapping("/GolfMember")
    public GolfMember createGolfMember(@RequestBody GolfMember newGolfMember) {
        return memberService.createGolfMember(newGolfMember);
    }

    @PostMapping("/GolfMembers/bulk")
    public List<GolfMember> createGolfMembers(@RequestBody List<GolfMember> newGolfMembers) {
        return memberService.createGolfMembers(newGolfMembers);
    }


    @PutMapping("/GolfMember/{id}")
    public GolfMember updateGolfMember(@RequestBody GolfMember updatedGolfMember, @PathVariable long id) {
        return memberService.updateGolfMember(updatedGolfMember);
    }
    @DeleteMapping("/GolfMember/{id}")
    public void deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
    }
}
