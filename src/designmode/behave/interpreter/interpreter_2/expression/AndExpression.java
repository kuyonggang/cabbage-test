package designmode.behave.interpreter.interpreter_2.expression;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AndExpression implements Expression {
    private List<Expression> expressions = new ArrayList<>();

    public AndExpression(String exp){
        String[] strExpressions = exp.trim().split("&&");
        for (String strExp :
                strExpressions) {
            if(strExp.contains(">")){
                expressions.add(new GreaterExpression(strExp));
            }else if(strExp.contains("<")){
                expressions.add(new LessExpression(strExp));
            }else if(strExp.contains("==")){
                expressions.add(new EqualExpression(strExp));
            }else{
                throw new RuntimeException("Expression is invalid:" + strExp);
            }
        }
    }

    @Override
    public boolean interpret(Map<String,Long> stats) {
        for (Expression exp :
                expressions) {
            if (!exp.interpret(stats)) {
                return false;
            }
        }
        return true;
    }
}
