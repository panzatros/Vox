package com.interpreter.vox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import static com.interpreter.vox.TokenType.*;

public class FuntionalScanner {
    private String source;
    private List<Token>  foundTokens = new ArrayList<>();
    private int line = 1;
    private int start = 0;
    private int current = 0;

    interface TokenAction extends Consumer<Void> {}

    private final Map<String, TokenAction> actionsMap = new HashMap<>();

    public FuntionalScanner(String source) {
        this.source = source;
        actionsMap.put('(', v -> ());
        actionsMap.put('(', v -> ());
        actionsMap.put('(', v -> ());
        actionsMap.put('(', v -> ());

    }

    public List<Token> proccess() {
        while(isAtEnd()) {
            start = current;
            processToken();
        }

        foundTokens.add(new Token(EOF, "", null, line));
        return foundTokens;
    }

    private boolean isAtEnd() {
        return current >= source.length();
    }

    private void string() {
        // here we
    }

    private String advance() {
        current++;
        return String.valueOf(source.charAt(current - 1));
    }

    private char peek() {
        if (isAtEnd()) return '\0';
        return source.charAt(current);
    }

    private char peekNext() {
        if (current + 1 >= source.length()) return '\0';
        return source.charAt(current+1);
    }


    private void processToken() {
        String input = advance();
        if (actionsMap.containsKey(input)) {
            actionsMap.get(input).accept(null);
        } else {
            System.out.println("No action found for input: " + input);
        }
    }

    private static final Map<String, TokenType> keywords;

    static {
        keywords = new HashMap<>();
        keywords.put("and",AND);
        keywords.put("class",CLASS);
        keywords.put("else",ELSE);
        keywords.put("false",FALSE);
        keywords.put("for",FOR);
        keywords.put("fun",FUN);
        keywords.put("if",IF);
        keywords.put("nil",NIL);
        keywords.put("or",OR);
        keywords.put("print",PRINT);
        keywords.put("return", RETURN);
        keywords.put("super",SUPER);
        keywords.put("this",THIS);
        keywords.put("true",TRUE);
        keywords.put("var",VAR);
        keywords.put("while",WHILE);
    }

}
