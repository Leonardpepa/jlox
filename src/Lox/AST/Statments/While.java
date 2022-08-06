package Lox.AST.Statments;

import Lox.AST.EXPRESSION.Expr;

public class While extends Stmt {
    final Expr condition;
    final Stmt body;

    While(Expr condition, Stmt body) {
        this.condition = condition;
        this.body = body;
    }

    @Override
    <R> R accept(Visitor<R> visitor) {
        return visitor.visitWhileStmt(this);
    }
}
