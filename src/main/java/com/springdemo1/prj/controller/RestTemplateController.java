package com.springdemo1.prj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springdemo1.prj.dto.MemberDTO;
import com.springdemo1.prj.service.RestTemplateService;

@RestController
@RequestMapping("/api/server/rest-template")
public class RestTemplateController {
	
	@Autowired
	private RestTemplateService restTemplateService;
	
	@GetMapping(value = "/demo")
	public String getDemo() {
		return restTemplateService.getDemo();
	}
	
	@GetMapping(value = "/name")
	public String getName() {
		return restTemplateService.getName();
	}
	
	@GetMapping(value = "/name2")
	public String getName2() {
		return restTemplateService.getName2();
	}
	
	@GetMapping(value = "/member")
	public ResponseEntity<MemberDTO> getMember() {
		return restTemplateService.postDto();
	}
	
	@GetMapping(value = "/add-header")
	public ResponseEntity<MemberDTO> addHeader() {
		return restTemplateService.addHeader();
	}
}
