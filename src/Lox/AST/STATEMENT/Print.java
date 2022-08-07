package Lox.AST.STATEMENT;

import Lox.AST.EXPRESSION.Expr;

public class Print extends Stmt {
    public final Expr expression;

    public Print(Expr expression) {
        this.expression = expression;
    }

    @Override
    public <R> R accept(Visitor<R> visitor) {
        return visitor.visitPrintStmt(this);
    }
}
