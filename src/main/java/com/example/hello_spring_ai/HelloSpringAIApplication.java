package com.example.hello_spring_ai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HelloSpringAIApplication {

	@Bean
	public ChatClient chatClient(ChatClient.Builder builder) {
		return builder.build();
	}

	public static void main(String[] args) {
//		ChatClient chatClient = SpringApplication.run(HelloSpringAIApplication.class, args).getBean(ChatClient.class);
		SpringApplication.run(HelloSpringAIApplication.class, args);
//		System.out.println(chatClient.prompt().user("Дай первую строчку богемской рапсодии").call().content());
	}

}
