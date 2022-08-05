package Lox.AST;

import Lox.AST.EXPRESSION.*;

class AstPrinter implements Expr.Visitor<String> {
    String print(Expr expr) {
        return expr.accept(this);
    }

    @Override
    public String visitAssignExpr(Assign expr) {
        return null;
    }

    @Override
    public String visitBinaryExpr(Binary expr) {
        return null;
    }

    @Override
    public String visitCallExpr(Call expr) {
        return null;
    }

    @Override
    public String visitGetExpr(Get expr) {
        return null;
    }

    @Override
    public String visitGroupingExpr(Grouping expr) {
        return null;
    }

    @Override
    public String visitLiteralExpr(Literal expr) {
        return null;
    }

    @Override
    public String visitLogicalExpr(Expr expr) {
        return null;
    }

    @Override
    public String visitSetExpr(Expr expr) {
        return null;
    }

    @Override
    public String visitSuperExpr(Super expr) {
        return null;
    }

    @Override
    public String visitThisExpr(This expr) {
        return null;
    }

    @Override
    public String visitUnaryExpr(Unary expr) {
        return null;
    }

    @Override
    public String visitVariableExpr(Variable expr) {
        return null;
    }
}