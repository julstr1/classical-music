package com.example.classicalmusic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class ClassicalMusicApplication {
	@RequestMapping("/")
	@ResponseBody
	String home() {return "Hello Composer!";}
	public static void main(String[] args) {
		SpringApplication.run(ClassicalMusicApplication.class, args);
	}

}
