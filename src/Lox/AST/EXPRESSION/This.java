package Lox.AST.EXPRESSION;

import Lox.Scanner.Token;

class This extends Expr {
    final Token keyword;

    This(Token keyword) {
        this.keyword = keyword;
    }

    @Override
    <R> R accept(Visitor<R> visitor) {
        return visitor.visitThisExpr(this);
    }
}
