package Lox.AST.EXPRESSION;

public class Literal extends Expr {
    public final Object value;

    Literal(Object value) {
        this.value = value;
    }

    @Override
    public <R> R accept(Visitor<R> visitor) {
        return visitor.visitLiteralExpr(this);
    }
}
