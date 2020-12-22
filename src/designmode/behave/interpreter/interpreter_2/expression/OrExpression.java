package designmode.behave.interpreter.interpreter_2.expression;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrExpression implements Expression {
    private List<Expression> expressions = new ArrayList<>();

    public OrExpression(String exp){
        String[] andExpressions = exp.split("\\|\\|");
        for (String andExpression :
                andExpressions) {
            expressions.add(new AndExpression(andExpression));
        }
    }

    @Override
    public boolean interpret(Map stats) {
        for (Expression exp :
                expressions) {
            if (exp.interpret(stats)) {
                return true;
            }
        }
        return false;
    }
}
