package Lox.Enviroment;

import Lox.Interpreter.Interpreter;

import java.util.List;

public interface LoxCallable {
    int arity();
    Object call(Interpreter interpreter, List<Object> arguments);
}