package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootApplication
@RestController
public class BracketCheckerApplication {

    private static Hello hello = new Hello();

    public static void main(String[] args) {
        SpringApplication.run(BracketCheckerApplication.class, args);
    }

    /**
     * Checks if the brackets in the given text are balanced.
     *
     * @param payload the object containing the text to check
     * @return the response with the result of the check in JSON format
     */
    @PostMapping("/api/checkBrackets")
    public ResponseEntity<?> checkBrackets(@RequestBody RequestPayload payload) {
        String text = payload.getText();
        if (text.isEmpty()) {
            return ResponseEntity.ok().body("{\"isEmpty\": true}");
        }
        if (isBracketsBalanced(text) && isTextBracketsBalanced(text)) {
            return ResponseEntity.ok().body("{\"isCorrect\": true}");
        } else {
            return ResponseEntity.ok().body("{\"isCorrect\": false}");
        }
    }

    /**
     * Inner class representing a request object with the text to check.
     */
    public static class RequestPayload {
        private final String text;

        public RequestPayload(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }

    /**
     * Checks if the brackets in the given text are balanced.
     *
     * @param text the text to check
     * @return true if the brackets are balanced, false otherwise
     */
    private boolean isBracketsBalanced(String text) {
        Stack<Character> stack = new Stack<>();

        for (char c : text.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    /**
     * Checks if there is text inside brackets in the given text.
     *
     * @param text the text to check
     * @return true if there is text inside brackets, false otherwise
     */
    private boolean isTextBracketsBalanced(String text) {
        Pattern pattern = Pattern.compile("\\([^\\s()]*\\)");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String content = matcher.group();
            if (content.length() <= 2) {
                return false;
            }
        }
        return true;
    }
}