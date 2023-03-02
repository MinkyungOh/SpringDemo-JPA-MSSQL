package com.springdemo1.prj.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springdemo1.prj.dto.MemberDTO;

@RestController
@RequestMapping("/api/v1/test-api")
public class TestController {
	
	private Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@GetMapping(value = "/test1")
	public String getTest1() {
		logger.info("getTest1 호출");
		return "Hello, World!";
	}
	
	@GetMapping(value = "/demo")
	public String getDemo() {
		logger.info("getDemo 호출");
		return "demo 호출하셨습니다.!";
	}
	
	// http://localhost:8080/api/v1/test-api/name?name=kkk
	@GetMapping(value = "/name")
	public String getTest2(@RequestParam String name) {
		logger.info("getTest2 호출");
		return "Hello, " + name + "!";
	}
	
	@GetMapping(value = "/name/{name}")
	public String getTest3(@PathVariable String name) {
		logger.info("getTest3 호출");
		return "Hello, " + name + "!";
	}
	
	@PostMapping(value = "/member")
	public ResponseEntity<MemberDTO> getMember(
		@RequestBody MemberDTO member,
		@RequestParam String name,
		@RequestParam String email,
		@RequestParam String organization
	) {
		logger.info("getMember 호출");
		return ResponseEntity.status(HttpStatus.OK).body(member);
	}
	
	@PostMapping(value = "/add-header")
	public ResponseEntity<MemberDTO> addHeader(@RequestHeader("demo-header") String header, @RequestBody MemberDTO member) {
		logger.info("add-header 호출");
		logger.info("header 값 : {}", header);
		
		return ResponseEntity.status(HttpStatus.OK).body(member);
	}

}
