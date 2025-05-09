package com.douglas.markdown_reviewer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import com.douglas.markdown_reviewer.aiservice.OpenAIService;

import lombok.RequiredArgsConstructor;

@ShellComponent
@RequiredArgsConstructor
public class ShellCommand {

  private final OpenAIService openAIService;

  @ShellMethod("Revisa um arquivo Markwon usando IA")
  public void review(@ShellOption(help = "Filepath") String path) throws IOException {
    String markdown = Files.readString(Path.of(path));
    String prompt = MarkdownPrompts.reviewMarkdown(markdown);
    String resultado = openAIService.prompt(prompt);

    System.out.println("\nResultado da Revisão:\n");
    System.out.println(resultado);
  }

  @ShellMethod("Corrige ortografia um arquivo Markwon usando IA")
  public void correct(@ShellOption(help = "Filepath") String path) throws IOException {
    String markdown = Files.readString(Path.of(path));
    String prompt = MarkdownPrompts.correctMarkdown(markdown);
    String resultado = openAIService.prompt(prompt);

    System.out.println("\nResultado da Correção:\n");
    System.out.println(resultado);
  }

  @ShellMethod("Oi")
  public void oi() {
    System.out.println("Oi");
  }
}
