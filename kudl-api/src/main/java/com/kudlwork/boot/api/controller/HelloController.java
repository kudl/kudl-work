package com.kudlwork.boot.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping(value = "/hi")
	public String hello() {
		return "api";
	}
}
