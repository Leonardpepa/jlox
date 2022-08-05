package Lox.AST.EXPRESSION;

import Lox.Scanner.Token;

public class Unary extends Expr {
    public final Token operator;
    public final Expr right;

    Unary(Token operator, Expr right) {
        this.operator = operator;
        this.right = right;
    }

    @Override
    public <R> R accept(Visitor<R> visitor) {
        return visitor.visitUnaryExpr(this);
    }
}
