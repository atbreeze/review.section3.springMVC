package com.cryptossu.review.section3.springMVC.member;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.HashMap;
import java.util.Map;

@RestController

//@RequestMapping(value = "/v1/members", produces = {MediaType.APPLICATION_JSON_VALUE})
@RequestMapping(value = "/v1/members")
@Validated
public class MemberController {

//    private final Map<Long, Map<String, Object>> members = new HashMap<>();
//
//    @PostConstruct
//    public void init() {
//        Map<String, Object> member1 = new HashMap<>();
//        long memberId = 1L;
//        member1.put("memberId", memberId);
//        member1.put("email", "hgd@gmail.com");
//        member1.put("name", "홍길동");
//        member1.put("phone", "010-1234-5678");
//
//        members.put(memberId, member1);
//    }

    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody MemberPostDTO memberPostDTO) {
//            @RequestHeader("user-agent") String userAgent,
//            @RequestParam("memberId") long memberId,
//            @RequestParam("email") String email,
//            @RequestParam("name") String name,
//            @RequestParam("phone") String phone) {

//        System.out.println("# email : " + email);
//        System.out.println("# name : " + name);
//        System.out.println("# phone : " + phone);
//
//        String response =
//                "{\"" +
//                        "email\":\"" + email + "\"," +
//                        "\"name\":\"" + name + "\",\"" +
//                        "phone\":\"" + phone +
//                        "\"}";
//        return response;

//        Map<String, String> map = new HashMap<>();

//        map.put("email", email);
//        map.put("name", name);
//        map.put("phone", phone);
////        System.out.println("user-agent: " + userAgent);
//        return new ResponseEntity<>(map, HttpStatus.CREATED);
//    }
        return new ResponseEntity<>(memberPostDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{member-id}")
    public ResponseEntity getMember(@PathVariable("member-id") long memberId) {
        System.out.println("# memberId: " + memberId);

//        retunr null;
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getMembers() {
        System.out.println("# get Members");

//        retunr null;
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/{member-id}")
//    public ResponseEntity patchMember(@PathVariable("member-id") long memberId){
//
//        members.get(memberId).put("phone", "010-9876-5432");
//        return new ResponseEntity<>(members.get(memberId), HttpStatus.CREATED);
//    }
    public ResponseEntity patchMember(@PathVariable("member-id") long memberId,
                                      @Valid @RequestBody MemberPatchDTO memberPatchDTO) {
        memberPatchDTO.setMemberId(memberId);

        return new ResponseEntity<MemberPatchDTO>(memberPatchDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteMember(@PathVariable("member-id") long memberId) {

        return new ResponseEntity<>(memberId, HttpStatus.NO_CONTENT);
    }
}
