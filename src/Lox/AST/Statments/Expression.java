package Lox.AST.Statments;

import Lox.AST.EXPRESSION.Expr;

public class Expression extends Stmt {
    public final Expr expression;

    public Expression(Expr expression) {
        this.expression = expression;
    }

    @Override
    public <R> R accept(Visitor<R> visitor) {
        return visitor.visitExpressionStmt(this);
    }
}
