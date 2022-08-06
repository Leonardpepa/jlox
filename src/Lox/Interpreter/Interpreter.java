package Lox.Interpreter;

import Lox.AST.EXPRESSION.*;
import Lox.AST.Statments.*;
import Lox.AST.Statments.Class;
import Lox.Enviroment.Environment;
import Lox.Error.RuntimeError;
import Lox.Scanner.Token;
import Lox.Utils.Utils;

import java.util.List;

public class Interpreter implements Expr.Visitor<Object>, Stmt.Visitor<Void> {

    private Environment environment = new Environment();

    public void interpret(List<Stmt> statements) {
        try {
            for (Stmt statement : statements) {
                execute(statement);
            }
        } catch (RuntimeError error) {
            Lox.Lox.runtimeError(error);
        }
    }

    @Override
    public Object visitAssignExpr(Assign expr) {
        Object value = evaluate(expr.value);
        environment.assign(expr.name, value);
        return value;
    }

    @Override
    public Object visitBinaryExpr(Binary expr) {
        Object left = evaluate(expr.left);
        Object right = evaluate(expr.right);
        switch (expr.operator.type) {
            case MINUS:
                return (double) left - (double) right;
            case SLASH:
//                if((double) right == 0){
//                    throw new RuntimeError(expr.operator, "Runtime Error | Division by 0");
//                }
                return (double) left / (double) right;
            case STAR:
                return (double) left * (double) right;
            case PLUS:
                if (left instanceof Double && right instanceof Double) {
                    return (double) left + (double) right;
                }
                if (left instanceof String && right instanceof String) {
                    return left + (String) right;
                }
//                if (left instanceof String || right instanceof String){
//                    if (left.toString().endsWith(".0")) left = left.toString().substring(0, left.toString().length() - 2);
//                    if (right.toString().endsWith(".0")) right = right.toString().substring(0, right.toString().length() - 2);
//                    return left.toString().concat(right.toString());
//                }
                throw new RuntimeError(expr.operator, "Operands must be two numbers or two strings.");
                // comparison
            case GREATER:
                checkNumberOperands(expr.operator, left, right);
                return (double) left > (double) right;
            case GREATER_EQUAL:
                checkNumberOperands(expr.operator, left, right);
                return (double) left >= (double) right;
            case LESS:
                checkNumberOperands(expr.operator, left, right);
                return (double) left < (double) right;
            case LESS_EQUAL:
                checkNumberOperands(expr.operator, left, right);
                return (double) left <= (double) right;
            // equality
            case BANG_EQUAL:
                return !isEqual(left, right);
            case EQUAL_EQUAL:
                return isEqual(left, right);
        }
        // Unreachable.
        return null;
    }

    @Override
    public Object visitCallExpr(Call expr) {
        return null;
    }

    @Override
    public Object visitGetExpr(Get expr) {
        return null;
    }

    @Override
    public Object visitGroupingExpr(Grouping expr) {
        return evaluate(expr.expression);
    }

    @Override
    public Object visitLiteralExpr(Literal expr) {
        return expr.value;
    }

    @Override
    public Object visitLogicalExpr(Expr expr) {
        return null;
    }

    @Override
    public Object visitSetExpr(Expr expr) {
        return null;
    }

    @Override
    public Object visitSuperExpr(Super expr) {
        return null;
    }

    @Override
    public Object visitThisExpr(This expr) {
        return null;
    }

    @Override
    public Object visitUnaryExpr(Unary expr) {
        Object right = evaluate(expr.right);
        switch (expr.operator.type) {
            case BANG:
                return !isTruthy(right);
            case MINUS:
                checkNumberOperand(expr.operator, right);
                return -(double) right;
        }
        // Unreachable.
        return null;
    }

    @Override
    public Object visitVariableExpr(Variable expr) {
        return environment.get(expr.name);
    }

    private Object evaluate(Expr expr) {
        return expr.accept(this);
    }

    private boolean isTruthy(Object object) {
        if (object == null) return false;
        if (object instanceof Boolean) return (boolean) object;
        return true;
    }

    private boolean isEqual(Object a, Object b) {
        if (a == null && b == null) return true;
        if (a == null) return false;
        return a.equals(b);
    }

    private void checkNumberOperand(Token operator, Object operand) {
        if (operand instanceof Double) return;
        throw new RuntimeError(operator, "Operand must be a number.");
    }

    private void checkNumberOperands(Token operator, Object left, Object right) {
        if (left instanceof Double && right instanceof Double) return;

        throw new RuntimeError(operator, "Operands must be numbers.");
    }

    // interpret statments
    @Override
    public Void visitBlockStmt(Block stmt) {
        return null;
    }

    @Override
    public Void visitClassStmt(Class stmt) {
        return null;
    }

    @Override
    public Void visitExpressionStmt(Expression stmt) {
        evaluate(stmt.expression);
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
        Object value = evaluate(stmt.expression);
        System.out.println(Utils.stringify(value));
        return null;
    }

    @Override
    public Void visitReturnStmt(Return stmt) {
        return null;
    }

    @Override
    public Void visitVarStmt(Var stmt) {
        Object value = null;
        if (stmt.initializer != null) {
            value = evaluate(stmt.initializer);
        }
        environment.define(stmt.name.lexeme, value);
        return null;
    }

    @Override
    public Void visitWhileStmt(While stmt) {
        return null;
    }

    private void execute(Stmt stmt) {
        stmt.accept(this);
    }
}