package Lox.AST.EXPRESSION;

import Lox.Scanner.Token;

class Assign extends Expr {
    final Token name;
    final Expr value;

    Assign(Token name, Expr value) {
        this.name = name;
        this.value = value;
    }

    @Override
    <R> R accept(Visitor<R> visitor) {
        return visitor.visitAssignExpr(this);
    }
}
