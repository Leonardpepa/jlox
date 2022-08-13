package Lox.Enviroment;

import Lox.AST.EXPRESSION.*;
import Lox.AST.STATEMENT.*;
import Lox.AST.STATEMENT.Class;
import Lox.Interpreter.Interpreter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Resolver implements Expr.Visitor<Void>, Stmt.Visitor<Void> {

    private final Stack<Map<String, Boolean>> scopes = new Stack<>();
    private final Interpreter interpreter;
    public Resolver(Interpreter interpreter) {
        this.interpreter = interpreter;
    }

    @Override
    public Void visitAssignExpr(Assign expr) {
        return null;
    }

    @Override
    public Void visitBinaryExpr(Binary expr) {
        return null;
    }

    @Override
    public Void visitCallExpr(Call expr) {
        return null;
    }

    @Override
    public Void visitGetExpr(Get expr) {
        return null;
    }

    @Override
    public Void visitGroupingExpr(Grouping expr) {
        return null;
    }

    @Override
    public Void visitLiteralExpr(Literal expr) {
        return null;
    }

    @Override
    public Void visitLogicalExpr(Logical expr) {
        return null;
    }

    @Override
    public Void visitSetExpr(Expr expr) {
        return null;
    }

    @Override
    public Void visitSuperExpr(Super expr) {
        return null;
    }

    @Override
    public Void visitThisExpr(This expr) {
        return null;
    }

    @Override
    public Void visitUnaryExpr(Unary expr) {
        return null;
    }

    @Override
    public Void visitVariableExpr(Variable expr) {
        return null;
    }

    @Override
    public Void visitBlockStmt(Block stmt) {
        beginScope();
        resolve(stmt.statements);
        endScope();
        return null;
    }

    @Override
    public Void visitClassStmt(Class stmt) {
        return null;
    }

    @Override
    public Void visitExpressionStmt(Expression stmt) {
        return null;
    }

    @Override
    public Void visitFunctionStmt(Function stmt) {
        return null;
    }

    @Override
    public Void visitIfStmt(If stmt) {
        return null;
    }

    @Override
    public Void visitPrintStmt(Print stmt) {
        return null;
    }

    @Override
    public Void visitReturnStmt(Return stmt) {
        return null;
    }

    @Override
    public Void visitVarStmt(Var stmt) {
        return null;
    }

    @Override
    public Void visitWhileStmt(While stmt) {
        return null;
    }

    private void beginScope() {
        scopes.push(new HashMap<String, Boolean>());
    }
    private void endScope() {
        scopes.pop();
    }
    void resolve(List<Stmt> statements) {
        for (Stmt statement : statements) {
            resolve(statement);
        }
    }
    private void resolve(Stmt stmt) {
        stmt.accept(this);
    }

    private void resolve(Expr expr) {
        expr.accept(this);
    }
}