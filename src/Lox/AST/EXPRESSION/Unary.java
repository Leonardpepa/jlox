package Lox.AST.EXPRESSION;

import Lox.Scanner.Token;

class Unary extends Expr {
    final Token operator;
    final Expr right;

    Unary(Token operator, Expr right) {
        this.operator = operator;
        this.right = right;
    }

    @Override
    <R> R accept(Visitor<R> visitor) {
        return visitor.visitUnaryExpr(this);
    }
}
