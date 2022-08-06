package Lox.AST.Statments;

import Lox.AST.EXPRESSION.Expr;

public class Print extends Stmt {
    final Expr expression;

    Print(Expr expression) {
        this.expression = expression;
    }

    @Override
    <R> R accept(Visitor<R> visitor) {
        return visitor.visitPrintStmt(this);
    }
}
