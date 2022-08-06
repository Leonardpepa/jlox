package Lox.AST.Statments;

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
    <R> R accept(Visitor<R> visitor) {
        return visitor.visitReturnStmt(this);
    }
}
