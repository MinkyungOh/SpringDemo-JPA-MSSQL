package com.springdemo1.prj.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springdemo1.prj.dto.MemberDTO;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

	@RequestMapping(value = "hello", method = RequestMethod.GET)
	public String getHello() {
		return "Hello World";
	}
	
	@GetMapping(value = "/variable")
	public String getVariable() {
		return "variable";
	}
	
	//http://127.0.0.1:8080/api/v1/get-api/variable1/vvvv-value
	@GetMapping(value = "/variable1/{variable}")
	public String getVariable1(@PathVariable String variable) {
		return variable;
	}
	
	//http://127.0.0.1:8080/api/v1/get-api/variable2/vvvv-value
	@GetMapping(value = "/variable2/{variable}")
	public String getVariable2(@PathVariable("variable") String var) {
		return var;
	}
	
	//http://127.0.0.1:8080/api/v1/get-api/request1?name=omin&email=omin@udnsk.com&organization=udns
	@GetMapping(value = "/request1")
	public String getRequestParam1(@RequestParam String name, @RequestParam String email, @RequestParam String organization) {
		return name + ", " + email + ", " + organization;
	}
	
	//http://127.0.0.1:8080/api/v1/get-api/request2?name=omin&email=omin@udnsk.com&organization=udns
	@GetMapping(value = "/request2")
	public String getRequestParam2(@RequestParam Map<String, String> paramMap) {
		StringBuilder sb = new StringBuilder();
		
		paramMap.entrySet().forEach(map -> {
			sb.append(map.getKey() + ": " + map.getValue() + "\n");
		});
		
		return sb.toString();
	}
	
	//http://127.0.0.1:8080/api/v1/get-api/request3?name=omin&email=omin@udnsk.com&organization=udns
	@GetMapping(value = "/request3")
	public String getRequestParam3(MemberDTO member) {
		return member.toString();
	}
	
}
