package com.classroomservices.ClassRoomSvcs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ClassRoomSvcsApplication {

	@GetMapping("hello")
	public String welcome(){
		return "hello world";
	}
	public static void main(String[] args) {
		SpringApplication.run(ClassRoomSvcsApplication.class, args);
	}

}
