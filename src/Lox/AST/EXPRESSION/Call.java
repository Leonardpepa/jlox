package Lox.AST.EXPRESSION;

import Lox.Scanner.Token;

import java.util.List;

class Call extends Expr {
    final Expr callee;
    final Token paren;
    final List<Expr> arguments;

    Call(Expr callee, Token paren, List<Expr> arguments) {
        this.callee = callee;
        this.paren = paren;
        this.arguments = arguments;
    }

    @Override
    <R> R accept(Visitor<R> visitor) {
        return visitor.visitCallExpr(this);
    }
}
