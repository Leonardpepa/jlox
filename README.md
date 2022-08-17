# JLOX is an interpreted scripting programming language implemented by reading the book [Crafting intepreters](https://craftinginterpreters.com/)

## Syntax Of JLOX
JLox is a high-level scripting interpreted garbage collected language with dynamic typing.
Functions are first class in Lox, which just means they are real values that you can get a reference to, store in variables, pass around.

### Variables
```console
    var x = 15; // number
    var name = "your name"; // string
    var yes = true; // booleans
    var no = false; // booleans
    var nullable = nil;
```

### Logical operators
```console
!true;  // false.
!false; // true.
true and false; // false.
true and true;  // true.
false or false; // false.
true or false;  // true.
```

### Control flow
```console
    var x = 15;
    if(x > 0){
        print "x > 0";
    }else {
        print "x <= 0";    
    }
```

### Loops
```console
    var i = 0;
    while(i < 10){
        print i;
        i = i + 1;
    }
    
    for(var j=0; j<5; j = j + 1){
        print j;
    }
```

### Functions
```console
    fun greetings(name){
        print "hello " + name;
    }
    
    greetings("leonard");
```

### Closures
```console
fun addPair(a, b) {
  return a + b;
}

fun identity(a) {
  return a;
}

print identity(addPair)(1, 2); // Prints "3".

fun makeCounter(){
    var c = 0;
    fun counter(){
        c = c + 1;
        print c;
    }
    return counter;
}

var counter1 = makeCounter();
var counter2 = makeCounter();

counter1(); // 1
counter2(); // 1
```

### Classes
```console
    class Animal {
        
        init(aname){
            this.name = aname;
        }
        
        makeNoise(){
            print "animal noise";
        }
        
        printDetails(){
            print this.name;
        }
    }
    
    var animal = Animal("something");
    print animal;
    animal.makeNoise();
    animal.printDetails();
```
### Inheritance
```console
    class Dog < Animal {
        init(aname, age){
            super.init(aname);
            this.age = age;
        }
        
        makeNoise(){
            print "woof woof";
        }
        
        printDetails(){
            super.printDetails();
            print this.age;
        }
    }
    var dog = Dog("doggo", 2);
    print dog;
    dog.makeNoise();
    dog.printDetails();
```
## File Strucure
* Lox.java [entry point of the program]
* AST [classes to represent the ast nodes]
* Enviroment [classes for semantic analysis and runtime representation of the functions and classes in lox]
* Intepreter [classes for the interpreter implemented with the visitor pattern]
* Parser [classes for parsing the code in to a syntax tree]
* Scanner [classes for lexical analysis]
* Utils [utility classes]
* Error [error handlers]
* tests [lox program's to test the interpreter]

## Topics Covered
* tokens and lexing
* abstract syntax trees
* recursive descent parsing
* prefix and infix expressions
* runtime representation of objects
* interpreting code using the Visitor pattern
* lexical scope
* environment chains for storing variables
* control flow
* functions with parameters
* closures
* static variable resolution and error detection
* classes
* constructors
* fields
* methods
* inheritance


## Lexical Grammar
```console
NUMBER → DIGIT+ ( "." DIGIT+ )? ;
STRING → "\"" <any char except "\"">* "\"" ;
IDENTIFIER → ALPHA ( ALPHA | DIGIT )* ;
ALPHA → "a" ... "z" | "A" ... "Z" | "_" ;
DIGIT → "0" ... "9" ;
```

## Context Free Grammar
```console
program → declaration* EOF ;

declaration → classDecl
 | funDecl
 | varDecl
 | statement ;

classDecl → "class" IDENTIFIER ( "<" IDENTIFIER )?
 "{" function* "}" ;

funDecl → "fun" function ;

varDecl → "var" IDENTIFIER ( "=" expression )? ";" ;

statement → exprStmt
 | forStmt
 | ifStmt
 | printStmt
 | returnStmt
 | whileStmt
 | block ;

exprStmt → expression ";" ;

forStmt → "for" "(" ( varDecl | exprStmt | ";" ) expression? ";" expression? ")" statement ;

ifStmt → "if" "(" expression ")" statement ( "else" statement )? ;

printStmt → "print" expression ";" ;

returnStmt → "return" expression? ";" ;

whileStmt → "while" "(" expression ")" statement ; 

block → "{" declaration* "}" ;

expression → assignment ;

assignment → ( call "." )? IDENTIFIER "=" assignment | logic_or ;

logic_or → logic_and ( "or" logic_and )* ;

logic_and → equality ( "and" equality )* ;

equality → comparison ( ( "!=" | "==" ) comparison )* ;

comparison → term ( ( ">" | ">=" | "<" | "<=" ) term )* ;

term → factor ( ( "-" | "+" ) factor )* ;

factor → unary ( ( "/" | "*" ) unary )* ;

unary → ( "!" | "-" ) unary | call ;

call → primary ( "(" arguments? ")" | "." IDENTIFIER )* ;

primary → "true" | "false" | "nil" | "this" | NUMBER | STRING | IDENTIFIER | "(" expression ")"
 | "super" "." IDENTIFIER ;
 
function → IDENTIFIER "(" parameters? ")" block ;

parameters → IDENTIFIER ( "," IDENTIFIER )* ;

arguments → expression ( "," expression )* ;

```

## How to run
if you don't provide a source file then the program opens the REPL and you can type and interpret your code line by line.
* clone the repo with git clone https://github.com/Leonardpepa/jlox
* cd into the project
* run the jar with java -jar JLOX.jar [file]
* or open with intellij and run the project


