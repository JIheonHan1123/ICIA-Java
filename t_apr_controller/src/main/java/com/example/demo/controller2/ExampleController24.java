package com.example.demo.controller2;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ExampleController24 {
	@GetMapping("/example24/start")
	public void example4() {
	}

	@PostMapping("/example24/end")
	public ResponseEntity<Sample4> example4(Sample4 sample) {
		List<MultipartFile> profiles = sample.getProfiles();
		for (MultipartFile p : profiles) {
			if (p.isEmpty() == false) {
				System.out.println(p.getOriginalFilename());
			}
		}
		return null;
	}
}
