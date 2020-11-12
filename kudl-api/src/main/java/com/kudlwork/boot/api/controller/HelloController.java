package com.kudlwork.boot.api.controller;

import com.kudlwork.boot.api.service.HelloService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController {

	private final HelloService helloService;

	@GetMapping(value = "/hi")
	public String hello() {
		return "api";
	}

	@GetMapping(value = "/products")
	public ResponseEntity findAllProductDetail() {
		return new ResponseEntity<>(helloService.findAllProductDetail(), HttpStatus.OK);
	}
}
