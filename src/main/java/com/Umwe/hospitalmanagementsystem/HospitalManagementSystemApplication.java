package com.Umwe.hospitalmanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@SpringBootApplication
public class HospitalManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalManagementSystemApplication.class, args);
	}

	@RestController
	public static class HomeController {

		@GetMapping("/")
		public RedirectView redirectToIndex() {
			return new RedirectView("/website/index.html");
		}

	}
}