package com.example.hello_spring_ai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.ollama.api.OllamaApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@RestController
public class TestController {

    RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/test")
    public String test(@RequestParam(name = "question", required = false) String question) {
//        if (question == null || question.isEmpty()) question = "Why is the sky blue?";
        if (question == null || question.isEmpty()) question = "Дай оригинальный текст песни Bohemian Rhapsody группы Queen";
//        String request = "{ \"model\": \"gemma3:4b-it-q4_K_M\", \"prompt\": \"" + question + "\", \"stream\": false}";
        String request = "{ \"model\": \"gemma3:4b-it-q4_K_M\", \"prompt\": \"" + question + "\", \"stream\": false, \"options\": {\"num_predict\": 100, \"temperature\": 0.7, \"top_k\": 40, \"top_p\": 0.9, \"repeat_penalty\": 1.1}}";

        return restTemplate.postForEntity("http://localhost:11434/api/generate", request, String.class).getBody();
//        return Objects.requireNonNull(restTemplate.postForEntity("http://localhost:11434/api/generate", request, ChatResponse.class).getBody()).getResults().toString();
    }
}
