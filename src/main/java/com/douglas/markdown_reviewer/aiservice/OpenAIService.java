package com.douglas.markdown_reviewer.aiservice;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OpenAIService implements AIServiceInterface {
  private final ChatClient.Builder chatClientBuilder;

  @Override
  public String prompt(String prompt) {
    ChatClient chatClient = chatClientBuilder.build();
    String response = chatClient.prompt().user(prompt).call().content();
    return response;
  }
}
