package Lox.AST.Statments;

import java.util.List;

public class Block extends Stmt {
    public final List<Stmt> statements;

    Block(List<Stmt> statements) {
        this.statements = statements;
    }

    @Override
    public <R> R accept(Visitor<R> visitor) {
        return visitor.visitBlockStmt(this);
    }
}
