package designmode.behave.interpreter.interpreter_2.expression;

import java.util.Map;

public class GreaterExpression implements Expression {
    private String key;
    private long val;

    public GreaterExpression(String key,long val){
        this.key = key;
        this.val = val;
    }

    public GreaterExpression(String exp){
        String[] elements = exp.trim().split("\\s+");
        if(elements.length != 3 || !elements[1].trim().equals(">")){
            throw new RuntimeException("Expression is invalid: " + exp);
        }
        this.key = elements[0].trim();
        this.val = Long.parseLong(elements[2].trim());
    }

    @Override
    public boolean interpret(Map<String,Long> stats) {
        if(!stats.containsKey(key)){
            return false;
        }
        long statVal = stats.get(key);
        return statVal > val;
    }
}
