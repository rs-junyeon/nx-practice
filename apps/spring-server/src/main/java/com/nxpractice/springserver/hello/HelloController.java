package com.nxpractice.springserver.hello;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello")
public class HelloController {

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public HelloResponse hello(@RequestParam(defaultValue = "world") String name) {
		return new HelloResponse("Hello, " + name + "!");
	}

}
