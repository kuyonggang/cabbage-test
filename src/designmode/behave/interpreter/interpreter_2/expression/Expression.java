package designmode.behave.interpreter.interpreter_2.expression;

import java.util.Map;

public interface Expression {
    boolean interpret(Map<String,Long> stats);
}
