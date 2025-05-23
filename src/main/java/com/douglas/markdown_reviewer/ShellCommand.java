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
  public void review(@ShellOption(help = "Filepath") String arg) throws IOException {
    String markdown = Files.readString(Path.of(arg));
    String prompt = MarkdownPrompts.reviewMarkdown(markdown);
    String resultado = openAIService.prompt(prompt);

    System.out.println("\nResultado da Revisão:\n");
    System.out.println(resultado);
  }

  @ShellMethod("Corrige ortografia um arquivo Markwon usando IA")
  public void correct(@ShellOption(help = "Filepath") String arg) throws IOException {
    String markdown = Files.readString(Path.of(arg));
    String prompt = MarkdownPrompts.correctMarkdown(markdown);
    String resultado = openAIService.prompt(prompt);

    System.out.println("\nResultado da Correção:\n");
    System.out.println(resultado);
  }

  @ShellMethod("Traduz um arquivo Markwon para Inglês usando IA")
  public void translate(@ShellOption(help = "Filepath") String arg) throws IOException {
    String markdown = Files.readString(Path.of(arg));
    String prompt = MarkdownPrompts.translateMarkdownToEnglish(markdown);
    String resultado = openAIService.prompt(prompt);

    System.out.println("\nResultado da Tradução:\n");
    System.out.println(resultado);
  }

  @ShellMethod("Manda o texto como prompt comum para a IA")
  public void msg(@ShellOption(help = "Mensagem") String arg) {
    String prompt = arg;
    String resultado = openAIService.prompt(prompt);

    System.out.println("\nResposta:\n");
    System.out.println(resultado);
  }
}
