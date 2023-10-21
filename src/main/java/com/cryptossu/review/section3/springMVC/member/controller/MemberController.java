package com.cryptossu.review.section3.springMVC.member.controller;

import com.cryptossu.review.section3.springMVC.ErrorResponse;
import com.cryptossu.review.section3.springMVC.member.mapstruct.MemberMapper;
import com.cryptossu.review.section3.springMVC.member.dto.MemberPatchDTO;
import com.cryptossu.review.section3.springMVC.member.dto.MemberPostDTO;
import com.cryptossu.review.section3.springMVC.member.dto.MemberResponseDto;
import com.cryptossu.review.section3.springMVC.member.entity.Member;
import com.cryptossu.review.section3.springMVC.member.service.MemberService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
//import com.cryptossu.review.section3.springMVC.member.mapstruct.MemberMapper;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController

@RequestMapping(value = "/v6/members")
//v5 mapStruct 활용한 Mapper 자동 생성으로 Mapper 인터페이스 컨트롤러 적용
//@RequestMapping(value = "/v4/members")
//Mapper클래스 직접 생성을 통한 DTO <-> Member 변환 기능 컨트롤러에서 분리
//@RequestMapping(value = "/v3/members")
// v3는 memberService Membercontroller 변수에 멤버 서비스를 DI 해주는거 1개 변경
@Validated
@Slf4j
public class MemberController {
    private final MemberService memberService;
    private final MemberMapper mapper;

//    //v2
//    public MemberController() {
//        this.memberService = new MemberService();
//    }

    // v3
    public MemberController(MemberService memberService, MemberMapper mapper) {
        this.memberService = memberService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody MemberPostDTO memberPostDTO) {

        Member member = mapper.memberPostDtoToMember(memberPostDTO);
        Member response = memberService.createMember(member);

        return new ResponseEntity<>(mapper.memberToMemberResponseDto(response), HttpStatus.CREATED);
    }

//        Member member = new Member();
//        member.setEmail(memberPostDTO.getEmail());
//        member.setName(memberPostDTO.getName());
//        member.setPhone(memberPostDTO.getPhone());
//
//        Member response = memberService.createMember(member);
//        return new ResponseEntity<>(response, HttpStatus.CREATED);
//    }

    @GetMapping("/{member-id}")
    public ResponseEntity getMember(@PathVariable("member-id") long memberId) {

        Member response = memberService.findMember(memberId);

        return new ResponseEntity<>(mapper.memberToMemberResponseDto(response), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity getMembers() {

//        List<Member> response = memberService.findMembers();
//
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
        List<Member> members = memberService.findMembers();

        List<MemberResponseDto> response =
                members.stream()
                        .map(member -> mapper.memberToMemberResponseDto(member))
                        .collect(Collectors.toList());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @PatchMapping("/{member-id}")

    public ResponseEntity patchMember(@PathVariable("member-id") long memberId,
                                      @Valid @RequestBody MemberPatchDTO memberPatchDTO) {
        memberPatchDTO.setMemberId(memberId);

        Member response = memberService.updateMember(mapper.memberPatchDtoToMember(memberPatchDTO));

        return new ResponseEntity<>(mapper.memberToMemberResponseDto(response), HttpStatus.OK);


//        Member member = new Member();
//        member.setMemberId(memberPatchDTO.getMemberId());
//        member.setName(memberPatchDTO.getName());
//        member.setPhone(memberPatchDTO.getPhone());
//
//        Member response = memberService.updateMember(member);
//
//        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteMember(@PathVariable("member-id") long memberId) {

        memberService.deleteMember(memberId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    //Exceptionhandler의 경우 컨트롤러마다 아래 코드의 중복이 발생 할수 있고, 다양한 유형의 예외를 처리하기에는 적절하지 않은 방식이다.
//    @ExceptionHandler
//    public ResponseEntity handleException(MethodArgumentNotValidException e) {
//
//        final List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
//
//        List<ErrorResponse.FieldError> errors =
//                fieldErrors.stream()
//                        .map(error -> new ErrorResponse.FieldError(
//                                error.getField(),
//                                error.getRejectedValue().toString(),
//                                error.getDefaultMessage()))
//                        .collect(Collectors.toList());
//
//        return new ResponseEntity(new ErrorResponse(errors), HttpStatus.BAD_REQUEST);
//    }
//
//    @ExceptionHandler
//    public ResponseEntity handleException(ConstraintViolationException e) {
//
//
//        return new ResponseEntity(HttpStatus.BAD_REQUEST);
//    }

}