package Lox.AST.EXPRESSION;

import Lox.Scanner.Token;

public class Super extends Expr {
    final Token keyword;
    final Token method;

    Super(Token keyword, Token method) {
        this.keyword = keyword;
        this.method = method;
    }

    @Override
    public <R> R accept(Visitor<R> visitor) {
        return visitor.visitSuperExpr(this);
    }
}
