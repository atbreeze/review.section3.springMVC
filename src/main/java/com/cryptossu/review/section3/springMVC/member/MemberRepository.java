package com.cryptossu.review.section3.springMVC.member;

import com.cryptossu.review.section3.springMVC.member.entity.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

//public interface MemberRepository extends CrudRepository<Member, Long> {
//    Optional<Member> findByEmail(String email);
public interface MemberRepository extends PagingAndSortingRepository<Member, Long> {

Optional<Member> findByEmail(String email);
}
