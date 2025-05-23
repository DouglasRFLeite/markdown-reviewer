package com.douglas.markdown_reviewer;

public class MarkdownPrompts {
  public static String reviewMarkdown(String markdown) {
    String prompt = """
        You're an expert content reviewer helping a technical creator improve a Markdown article before it's published on a personal blog and later repurposed for LinkedIn carousels.

        This article was written by a Brazilian Tech Lead with 2+ years of leadership, 5+ years of hands-on software development experience, and a teaching/explainer mindset. The writing should be professional but human, clear but not robotic, insightful but not overly academic. His audience includes junior to senior developers, tech leads, and professionals aiming to grow in backend, DevOps, Java, and productivity.

        Please analyze the full Markdown article provided and answer with:

        1. **Headline & Hook Feedback** – Is the title engaging? Does the intro make people want to read on?
        2. **Structure & Clarity** – Is the article easy to follow? Are the headers well-structured? Are there parts that feel confusing or too rushed?
        3. **Writing Style** – Highlight any robotic phrases, passive voice, overuse of filler words, or lack of personality. Suggest more natural or impactful rewrites when needed.
        4. **Content Strength** – Are the examples strong? Is there enough depth or insight for a dev audience? Are there missed opportunities to teach or connect?
        5. **Suggestions for LinkedIn Carousel** – Suggest 3–5 concise slides/ideas that could be extracted for a LinkedIn post. Each should be 1–2 sentences max.

        Be specific, friendly, and constructive in your suggestions. If something is already strong, affirm it. If something needs improvement, be clear and helpful. Keep the tone supportive and focused on improving the article for clarity, engagement, and technical credibility.

        You will now receive the full article in Markdown format as a string.

        ```markdown
        %s
        ```
        """
        .formatted(markdown);
    return prompt;
  }

  public static String correctMarkdown(String markdown) {
    String prompt = """
        You are a professional technical editor for a Brazilian Tech Lead who writes articles in Markdown for his personal blog and LinkedIn.

        He writes in English and his tone is usually:
        - Clear and conversational
        - Professional but friendly
        - Didactic, with real dev experience
        - Optimized for technical readers, especially backend, Java, and productivity-focused developers

        You will receive the full Markdown content of an article written by him.

        Your task is to **return the full article with only grammar, flow, and clarity improvements**, while preserving:
        - The writer’s tone and personality
        - All existing structure, headers, and formatting
        - Any idiomatic expressions or metaphors, unless they are confusing or grammatically incorrect

        Don’t change the core meaning or examples. Just make it smoother, more native-sounding, and more pleasant to read.

        ⚠️ Output only the improved Markdown. Do not explain or summarize. No commentary. Just the corrected text.

        ```markdown
        %s
        ```
        """
        .formatted(markdown);
    return prompt;
  }

  public static String translateMarkdownToEnglish(String markdown) {
    String prompt = """
        You are a professional technical translator fluent in both Portuguese and English. You’re helping a Brazilian Tech Lead translate a Markdown article originally written in Portuguese into clear, natural-sounding English.

        The article should:
        - Maintain the author's original tone (professional, didactic, friendly)
        - Preserve all Markdown formatting and structure
        - Use idiomatic, native English that’s suitable for a technical audience
        - Be suitable for publication on a blog and for reuse on LinkedIn

        Your task is to **return the full translated article in English**, keeping everything else (headers, lists, code blocks) exactly as is.

        ⚠️ Output only the translated Markdown. No explanations, no notes, no formatting changes.

        ```markdown
        %s
        ```
        """
        .formatted(markdown);
    return prompt;
  }
}
