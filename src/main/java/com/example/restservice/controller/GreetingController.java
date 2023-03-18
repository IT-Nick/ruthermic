package com.example.restservice.controller;

import java.util.concurrent.atomic.AtomicLong;

import com.example.restservice.dto.Greeting;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@PostMapping("/greeting")
	public Greeting greetingPost(@RequestBody Greeting greeting) {
		return new Greeting(counter.incrementAndGet(), greeting.content());
	}

	@GetMapping("/healthcheck")
	public String healthcheck() {
		return "Ok";
	}
}
