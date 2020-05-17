package com.ascoprp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ascoprp.model.HelloBean;

@RestController
public class HelloWorldResource {

	@GetMapping(path = "/hello")
	public String printHello() {
		return "Hello...";
	}

	@GetMapping(path = "/hellobean")
	public HelloBean printHelloBean() {
		return new HelloBean("Hello Message...sasas.xaxa..");
	}
	
	// /hellobean/pathvariable/krishna
	@GetMapping(path = "/hellobean/pathvariable/{name}")
	public HelloBean printHelloPathVariable(@PathVariable String name) {
		return new HelloBean("Hello Message..."+name);
	}
	
	@GetMapping(path = "/internationalized")
	public String internationalized(@PathVariable String name) {
		return "Good Morning...";
	}
}
