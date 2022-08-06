package Lox.AST.Statments;

import Lox.Scanner.Token;

import java.util.List;

public class Function extends Stmt {
    final Token name;
    final List<Token> params;
    final List<Stmt> body;

    Function(Token name, List<Token> params, List<Stmt> body) {
        this.name = name;
        this.params = params;
        this.body = body;
    }

    @Override
    public <R> R accept(Visitor<R> visitor) {
        return visitor.visitFunctionStmt(this);
    }
}
