package com.capgemini.springboot.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

//	@RequestMapping("/")
	@GetMapping("/")
	public String hello() {
		System.out.println("Hello Sajal");
		return "Hello Sajal Ganjewala!";
	}

//	@RequestMapping("/hi")
	@GetMapping("hi")
	public String hi() {
//		System.out.println("Hi Sajal");
		return "Hi Sajal Ganjewala!";
	}
}
