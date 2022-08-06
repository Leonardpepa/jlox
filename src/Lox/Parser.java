package Lox;

import Lox.Scanner.Token;

import java.util.List;

public class Parser {
    private final List<Token> tokens;
    private int current = 0;
    Parser(List<Token> tokens) {
        this.tokens = tokens;
    }
}