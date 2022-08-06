package Lox.AST.Statments;

import Lox.AST.EXPRESSION.Expr;
import Lox.Scanner.Token;

public class Var extends Stmt {
    public final Token name;
    public final Expr initializer;

    public Var(Token name, Expr initializer) {
        this.name = name;
        this.initializer = initializer;
    }

    @Override
    public <R> R accept(Visitor<R> visitor) {
        return visitor.visitVarStmt(this);
    }
}
