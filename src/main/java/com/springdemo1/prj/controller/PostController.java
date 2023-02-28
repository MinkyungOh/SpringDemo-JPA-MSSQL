package com.springdemo1.prj.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springdemo1.prj.dto.MemberDTO;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {

	//http://127.0.0.1:8080/api/v1/post-api/member
	@PostMapping(value = "/member")
	public String getPostMember(@RequestBody Map<String, Object> paramMap) {
		StringBuilder sb = new StringBuilder();
		
		paramMap.entrySet().forEach(map -> {
			sb.append(map.getKey() + ": " + map.getValue() + "\n");
		});
		
		return sb.toString();
	}
	
	//http://127.0.0.1:8080/api/v1/post-api/member2
	@PostMapping(value = "/member2")
	public String getPostMember2(@RequestBody MemberDTO member) {
		return member.toString();
	}
}
