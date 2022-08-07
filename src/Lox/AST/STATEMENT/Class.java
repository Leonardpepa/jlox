package Lox.AST.STATEMENT;

import Lox.AST.EXPRESSION.Variable;
import Lox.Scanner.Token;

import java.util.List;

public class Class extends Stmt {
    final Token name;
    final Variable superclass;
    final List<Function> methods;

    Class(Token name, Variable superclass, List<Function> methods) {
        this.name = name;
        this.superclass = superclass;
        this.methods = methods;
    }

    @Override
    public <R> R accept(Visitor<R> visitor) {
        return visitor.visitClassStmt(this);
    }
}
