package Lox.AST.EXPRESSION;

import Lox.Scanner.Token;

public class This extends Expr {
    final Token keyword;

    This(Token keyword) {
        this.keyword = keyword;
    }

    @Override
    public <R> R accept(Visitor<R> visitor) {
        return visitor.visitThisExpr(this);
    }
}
