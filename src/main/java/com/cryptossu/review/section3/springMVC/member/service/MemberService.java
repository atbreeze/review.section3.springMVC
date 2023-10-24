package com.cryptossu.review.section3.springMVC.member.service;

import com.cryptossu.review.section3.springMVC.member.MemberRepository;
import com.cryptossu.review.section3.springMVC.member.exception.BusinessLogicException;
import com.cryptossu.review.section3.springMVC.member.exception.ExceptionCode;
import com.cryptossu.review.section3.springMVC.member.entity.Member;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member createMember(Member member) {
//        Member createdMember = member;
//        return createdMember;
        verifyExistsEmail(member.getEmail());
        return memberRepository.save(member);
    }

    public Member updateMember(Member member) {

//        Member updatedMember = member;
//        return updatedMember;
//        throw new BusinessLogicException(ExceptionCode.MEMBER_NOT_ALLOWED);
        Member findMember = findVerifiedMember(member.getMemberId());

        Optional.ofNullable((member.getName()))
                .ifPresent(name -> findMember.setName(name));
        Optional.ofNullable(member.getPhone())
                .ifPresent(phone -> findMember.setPhone(phone));

        return memberRepository.save(findMember);
    }

    public Member findMember(long memberId) {
//        Member member = new Member(memberId, "cryptossu@gmail.com", "cryptossu", "010-9876-5432");
//        return member;
//        throw new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND);
        return findVerifiedMember(memberId);
    }

    public List<Member> findMembers() {
//        List<Member> members = List.of(
//                new Member(1, "cryptossu@gmail.com", "cryptossu", "010-9876-5432"),
//                new Member(2, "atbreeze@gmail.com", "atbreeze", "010-1234-5678")
//        );
//        return members;
        return (List<Member>) memberRepository.findAll();
    }

    public void deleteMember(long memberId) {
//        throw new BusinessLogicException(ExceptionCode.INTERNAL_SEVER_ERROR);
        Member findMember = findVerifiedMember(memberId);
        memberRepository.delete(findMember);
    }

    public Member findVerifiedMember(long memberId) {
        Optional<Member> optionalMember = memberRepository.findById(memberId);
        Member findMember = optionalMember.orElseThrow(() -> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
        return findMember;
    }

    private void verifyExistsEmail(String email) {
        Optional<Member> member = memberRepository.findByEmail(email);
        if (member.isPresent()) throw new BusinessLogicException(ExceptionCode.MEMBER_EXISTS);
    }
}
