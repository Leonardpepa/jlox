package Lox.AST.Statments;

import Lox.AST.EXPRESSION.Expr;
import Lox.Scanner.Token;

public class Var extends Stmt {
    final Token name;
    final Expr initializer;

    Var(Token name, Expr initializer) {
        this.name = name;
        this.initializer = initializer;
    }

    @Override
    <R> R accept(Visitor<R> visitor) {
        return visitor.visitVarStmt(this);
    }
}
