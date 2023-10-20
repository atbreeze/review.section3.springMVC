//package com.cryptossu.review.section3.springMVC.member.dto;
//
//import com.cryptossu.review.section3.springMVC.member.dto.MemberResponseDto;
//import com.cryptossu.review.section3.springMVC.member.entity.Member;
//import com.cryptossu.review.section3.springMVC.member.dto.MemberPatchDTO;
//import com.cryptossu.review.section3.springMVC.member.dto.MemberPostDTO;
//import org.springframework.stereotype.Component;
//
//@Component
//public class MemberMapper {
//
//    public Member memberPostDtoToMember(MemberPostDTO memberPostDto) {
//        return new Member(0L,
//                memberPostDto.getEmail(),
//                memberPostDto.getName(),
//                memberPostDto.getPhone());
//    }
//
//    public Member memberPatchDtoToMember(MemberPatchDTO memberPatchDTO) {
//        return new Member(memberPatchDTO.getMemberId(),
//                null,
//                memberPatchDTO.getName(),
//                memberPatchDTO.getPhone());
//    }
//
//    public MemberResponseDto memberToMemberResponseDto(Member member) {
//        return new MemberResponseDto(member.getMemberId(),
//                member.getEmail(),
//                member.getName(),
//                member.getPhone());
//    }
//
//}
