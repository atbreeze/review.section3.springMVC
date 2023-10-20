package com.cryptossu.review.section3.springMVC.member.mapstruct;

import com.cryptossu.review.section3.springMVC.member.entity.Member;
import com.cryptossu.review.section3.springMVC.member.dto.MemberPatchDTO;
import com.cryptossu.review.section3.springMVC.member.dto.MemberPostDTO;
import com.cryptossu.review.section3.springMVC.member.dto.MemberResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
// componentModer ="spring"을 지정해 주면 스프링의 빈으로 등록이 된다.

public interface MemberMapper {

    Member memberPostDtoToMember(MemberPostDTO memberPostDTO);
    Member memberPatchDtoToMember(MemberPatchDTO memberPatchDTO);
    MemberResponseDto memberToMemberResponseDto(Member member);
}
