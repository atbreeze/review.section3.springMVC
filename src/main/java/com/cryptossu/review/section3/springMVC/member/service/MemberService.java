package com.cryptossu.review.section3.springMVC.member.service;

import com.cryptossu.review.section3.springMVC.member.exception.BusinessLogicException;
import com.cryptossu.review.section3.springMVC.member.exception.ExceptionCode;
import com.cryptossu.review.section3.springMVC.member.entity.Member;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    public Member createMember(Member member) {

        Member createdMember = member;
        return createdMember;
    }

    public Member updateMember(Member member) {

//        Member updatedMember = member;
//        return updatedMember;
        throw new BusinessLogicException(ExceptionCode.MEMBER_NOT_ALLOWED);
    }

    public Member findMember(long memberId) {
//        Member member = new Member(memberId, "cryptossu@gmail.com", "cryptossu", "010-9876-5432");
//        return member;
        throw new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND);
    }


    public List<Member> findMembers() {
        List<Member> members = List.of(
                new Member(1, "cryptossu@gmail.com", "cryptossu", "010-9876-5432"),
                new Member(2, "atbreeze@gmail.com", "atbreeze", "010-1234-5678")
        );
        return members;
    }

    public void deleteMember(long memberId) {

        throw new BusinessLogicException(ExceptionCode.INTERNAL_SEVER_ERROR);
    }
}
