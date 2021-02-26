package com.example.retriesdemo;

import com.example.retriesdemo.service.ReadFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@SpringBootApplication
@Component
@RequiredArgsConstructor
public class RetriesDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetriesDemoApplication.class, args);
	}

}
