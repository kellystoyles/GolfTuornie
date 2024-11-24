package com.keyin.domain.golfmember;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.keyin.domain.golftournament.Tournament;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "member")
public class GolfMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String email;
    private String phone;
    private LocalDate startDate;
    private Integer membershipDuration;

    public GolfMember() {
    }

    public GolfMember(String name, String address, String email, String phone,
                      LocalDate startDate, Integer membershipDuration) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.startDate = startDate;
        this.membershipDuration = membershipDuration;
    }


    public Long getId() {
        return id;}
    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;}
    public void setName(String name) {
        this.name = name;
    }


    public String getAddress() {
        return address;}
    public void setAddress(String address) {
        this.address = address;
    }


    public String getEmail() {
        return email;}
    public void setEmail(String email) {
        this.email = email;
    }


    public String getPhone() {
        return phone;}
    public void setPhone(String phone) {
        this.phone = phone;
    }


    public LocalDate getStartDate() {
        return startDate;}
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }


    public Integer getMembershipDuration() {
        return membershipDuration;}
    public void setMembershipDuration(Integer membershipDuration) {
        this.membershipDuration = membershipDuration;
    }

    @ManyToMany(mappedBy = "participatingMembers")
    @JsonBackReference
    private Set<Tournament> tournaments = new HashSet<>();

    public Set<Tournament> getTournaments() {
        return tournaments;}
    public void setTournaments(Set<Tournament> tournaments) {
        this.tournaments = tournaments;
    }

    public void addTournament(Tournament tournament) {
        this.tournaments.add(tournament);
        tournament.getParticipatingMembers().add(this);
    }

    public void removeTournament(Tournament tournament) {
        this.tournaments.remove(tournament);
        tournament.getParticipatingMembers().remove(this);
    }
}