package Lox.AST.EXPRESSION;

import Lox.Scanner.Token;

class Get extends Expr {
    final Expr object;
    final Token name;

    Get(Expr object, Token name) {
        this.object = object;
        this.name = name;
    }

    @Override
    <R> R accept(Visitor<R> visitor) {
        return visitor.visitGetExpr(this);
    }
}
