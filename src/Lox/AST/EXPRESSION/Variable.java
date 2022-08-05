package Lox.AST.EXPRESSION;

import Lox.Scanner.Token;

public class Variable extends Expr {
    final Token name;

    Variable(Token name) {
        this.name = name;
    }

    @Override
    public <R> R accept(Visitor<R> visitor) {
        return visitor.visitVariableExpr(this);
    }
}
