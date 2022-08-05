package Lox.AST.EXPRESSION;

import Lox.Scanner.Token;

class Set extends Expr {
    Set(Expr object, Token name, Expr value) {
        this.object = object;
        this.name = name;
        this.value = value;
    }

    @Override
    <R> R accept(Visitor<R> visitor) {
        return visitor.visitSetExpr(this);
    }

    final Expr object;
    final Token name;
    final Expr value;
}
