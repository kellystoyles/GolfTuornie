package com.keyin.domain.golfmember;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface MemberRepository extends CrudRepository<GolfMember, Long> {
    List<GolfMember> findByNameContaining(String name);

    List<GolfMember> findByPhone(String phone);

    List<GolfMember> findByStartDate(LocalDate date);


}

