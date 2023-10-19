package com.cryptossu.review.section3.springMVC.member;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController

@RequestMapping(value = "/v2/members")
@Validated
public class MemberController {
    private final MemberService memberService;

//    //v2
//    public MemberController() {
//        this.memberService = new MemberService();
//    }

    // v3
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody MemberPostDTO memberPostDTO) {

        Member member = new Member();
        member.setEmail(memberPostDTO.getEmail());
        member.setName(memberPostDTO.getName());
        member.setPhone(memberPostDTO.getPhone());

        Member response = memberService.createMember(member);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{member-id}")
    public ResponseEntity getMember(@PathVariable("member-id") long memberId) {
        Member response = memberService.findMember(memberId);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{member-id}")
    public ResponseEntity getMembers() {

        List<Member> response = memberService.findMembers();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PatchMapping("/{member-id}")

    public ResponseEntity patchMember(@PathVariable("member-id") long memberId,
                                      @Valid @RequestBody MemberPatchDTO memberPatchDTO) {
        memberPatchDTO.setMemberId(memberId);

        Member member = new Member();
        member.setMemberId(memberPatchDTO.getMemberId());
        member.setName(memberPatchDTO.getName());
        member.setPhone(memberPatchDTO.getPhone());

        Member response = memberService.updateMember(member);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteMember(@PathVariable("member-id") long memberId) {

        memberService.deleteMember(memberId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}