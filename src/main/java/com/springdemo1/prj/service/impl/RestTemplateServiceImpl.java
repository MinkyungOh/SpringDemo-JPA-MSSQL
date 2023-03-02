package com.springdemo1.prj.service.impl;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.springdemo1.prj.dto.MemberDTO;
import com.springdemo1.prj.service.RestTemplateService;

@Service
public class RestTemplateServiceImpl implements RestTemplateService {

	private Logger logger = LoggerFactory.getLogger(RestTemplateServiceImpl.class);

	@Override
	public String getDemo() {
		URI uri = UriComponentsBuilder
				.fromUriString("http://localhost:8080")
				.path("/api/v1/test-api/demo")
				.encode()
				.build()
				.toUri();
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);
		
		logger.info("status code : {}", responseEntity.getStatusCode());
		logger.info("body : {}", responseEntity.getBody());
		
		return responseEntity.getBody();
	}

	@Override
	public String getName() {
		URI uri = UriComponentsBuilder
				.fromUriString("http://localhost:8080")
				.path("/api/v1/test-api/name")
				.queryParam("name", "AAA")
				.encode()
				.build()
				.toUri();
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);
		
		logger.info("status code : {}", responseEntity.getStatusCode());
		logger.info("body : {}", responseEntity.getBody());
		
		return responseEntity.getBody();
	}

	@Override
	public String getName2() {
		URI uri = UriComponentsBuilder
				.fromUriString("http://localhost:8080")
				.path("/api/v1/test-api/name/{name}")
				.encode()
				.build()
				.expand("YYY")
				.toUri();
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);
		
		logger.info("status code : {}", responseEntity.getStatusCode());
		logger.info("body : {}", responseEntity.getBody());
		
		return responseEntity.getBody();
	}

	@Override
	public ResponseEntity<MemberDTO> postDto() {
		URI uri = UriComponentsBuilder
				.fromUriString("http://localhost:8080")
				.path("/api/v1/test-api/member")
				.queryParam("name", "홍길동")
				.queryParam("email", "hong@gmail")
				.queryParam("organization", "AA조직")
				.encode()
				.build()
				.expand("YYY")
				.toUri();
		
		MemberDTO member = new MemberDTO();
		member.setName("하하하");
		member.setEmail("haha@gmail");
		member.setOrganization("BB조직");
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<MemberDTO> responseEntity = restTemplate.postForEntity(uri, member, MemberDTO.class);
		
		logger.info("status code : {}", responseEntity.getStatusCode());
		logger.info("body : {}", responseEntity.getBody());
		
		return responseEntity;
	}

	@Override
	public ResponseEntity<MemberDTO> addHeader() {
		URI uri = UriComponentsBuilder
				.fromUriString("http://localhost:8080")
				.path("/api/v1/test-api/add-header")
				.encode()
				.build()
				.toUri();
		
		MemberDTO member = new MemberDTO();
		member.setName("하하하");
		member.setEmail("haha@gmail");
		member.setOrganization("BB조직");
		
		RequestEntity<MemberDTO> requestEntity = RequestEntity
				.post(uri)
				.header("demo-header", "this is demo")
				.body(member);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<MemberDTO> responseEntity = restTemplate.exchange(requestEntity, MemberDTO.class);
		
		logger.info("status code : {}", responseEntity.getStatusCode());
		logger.info("body : {}", responseEntity.getBody());
		
		return responseEntity;
	}
	
	
}
