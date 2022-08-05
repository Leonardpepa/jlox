package Lox.AST.EXPRESSION;

import Lox.Scanner.Token;

class Variable extends Expr {
    final Token name;

    Variable(Token name) {
        this.name = name;
    }

    @Override
    <R> R accept(Visitor<R> visitor) {
        return visitor.visitVariableExpr(this);
    }
}
