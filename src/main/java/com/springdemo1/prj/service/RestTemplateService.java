package com.springdemo1.prj.service;

import org.springframework.http.ResponseEntity;

import com.springdemo1.prj.dto.MemberDTO;

public interface RestTemplateService {

	public String getDemo();
	
	public String getName();
	
	public String getName2();
	
	public ResponseEntity<MemberDTO> postDto();
	
	public ResponseEntity<MemberDTO> addHeader();
}
