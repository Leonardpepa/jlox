package Lox.AST.STATEMENT;

import Lox.AST.EXPRESSION.Expr;
import Lox.Scanner.Token;

public class Return extends Stmt {
    final Token keyword;
    final Expr value;

    Return(Token keyword, Expr value) {
        this.keyword = keyword;
        this.value = value;
    }

    @Override
    public <R> R accept(Visitor<R> visitor) {
        return visitor.visitReturnStmt(this);
    }
}
