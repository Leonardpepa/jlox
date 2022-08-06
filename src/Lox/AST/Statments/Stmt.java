package Lox.AST.Statments;

public abstract class Stmt {
    abstract <R> R accept(Visitor<R> visitor);
    // Nested Stmt classes here...

    interface Visitor<R> {
        R visitBlockStmt(Block stmt);

        R visitClassStmt(Class stmt);

        R visitExpressionStmt(Expression stmt);

        R visitFunctionStmt(Function stmt);

        R visitIfStmt(If stmt);

        R visitPrintStmt(Print stmt);

        R visitReturnStmt(Return stmt);

        R visitVarStmt(Var stmt);

        R visitWhileStmt(While stmt);
    }

}
