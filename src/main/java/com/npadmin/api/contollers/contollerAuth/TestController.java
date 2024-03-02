package com.npadmin.api.contollers.contollerAuth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
	@GetMapping("/dummy")
	String hello() {
		return "hello man";
    }

}
