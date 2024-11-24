package com.keyin.domain.golftournament;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.keyin.domain.golfmember.GolfMember;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tournament")
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private String location;
    private BigDecimal entryFee;
    private BigDecimal cashPrizeAmount;

    @ManyToMany
    @JoinTable(
            name = "tournament_members",
            joinColumns = @JoinColumn(name = "tournament_id"),
            inverseJoinColumns = @JoinColumn(name = "member_id")
    )
    @JsonManagedReference
    private Set<GolfMember> participatingMembers = new HashSet<>();



    public Tournament() {
    }


    public Tournament(String name, LocalDate startDate, LocalDate endDate, String location,
                      BigDecimal entryFee, BigDecimal cashPrizeAmount) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.entryFee = entryFee;
        this.cashPrizeAmount = cashPrizeAmount;

    }


    public Long getId() {
        return id;}

    public String getName() {
        return name;}
    public void setName(String name) {
        this.name = name;
    }


    public LocalDate getStartDate() {
        return startDate;}
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }


    public LocalDate getEndDate() {
        return endDate;}
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;}
    public void setLocation(String location) {
        this.location = location;
    }


    public BigDecimal getEntryFee() {
        return entryFee;}
    public void setEntryFee(BigDecimal entryFee) {
        this.entryFee = entryFee;
    }


    public BigDecimal getCashPrizeAmount() {
        return cashPrizeAmount;}
    public void setCashPrizeAmount(BigDecimal cashPrizeAmount) {
        this.cashPrizeAmount = cashPrizeAmount;
    }


    public Set<GolfMember> getParticipatingMembers() {
        return participatingMembers;}
    public void setParticipatingMembers(Set<GolfMember> participatingMembers) {
        this.participatingMembers = participatingMembers;
    }

    public void addMember(GolfMember member) {
        this.participatingMembers.add(member);
        member.getTournaments().add(this);
    }

    public void removeMember(GolfMember member) {
        this.participatingMembers.remove(member);
        member.getTournaments().remove(this);
    }
}