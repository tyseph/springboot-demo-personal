package com.capgemini.springboot.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RandomTest {

//	@RequestMapping("/")
	@GetMapping("/")
	public String hello() {
		System.out.println("Hello Sajal");
		return "Hello Sajal Ganjewala!";
	}

//	@RequestMapping("/hi")
	@GetMapping("/hi")
	public String hi() {
//		System.out.println("Hi Sajal");
		return "Hi Sajal Ganjewala!";
	}

	@RequestMapping("/random")
	@GetMapping("/random")
	public ResponseEntity<String> random() {
		return new ResponseEntity<>("THIS IS A RANDOM TEST", HttpStatus.OK);
//		System.out.println("Hi Sajal");
	}
}
