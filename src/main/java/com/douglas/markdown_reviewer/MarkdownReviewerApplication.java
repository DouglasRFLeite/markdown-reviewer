package com.douglas.markdown_reviewer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MarkdownReviewerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarkdownReviewerApplication.class, args);
	}

	@Bean
	public CommandLineRunner shutdownRunner(ConfigurableApplicationContext context) {
		return args -> {
			SpringApplication.exit(context, () -> 0);
		};
	}
}
