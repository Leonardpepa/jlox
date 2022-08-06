package Lox.AST.Statments;

import Lox.AST.EXPRESSION.Expr;

public class Expression extends Stmt {
    final Expr expression;

    Expression(Expr expression) {
        this.expression = expression;
    }

    @Override
    <R> R accept(Visitor<R> visitor) {
        return visitor.visitExpressionStmt(this);
    }
}
