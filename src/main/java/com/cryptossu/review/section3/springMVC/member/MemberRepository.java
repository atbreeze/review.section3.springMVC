package com.cryptossu.review.section3.springMVC.member;

import com.cryptossu.review.section3.springMVC.member.entity.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MemberRepository extends CrudRepository<Member, Long> {
    Optional<Member> findByEmail(String email);
}
