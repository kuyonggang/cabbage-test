package designmode.behave.interpreter.interpreter_2;

import designmode.behave.interpreter.interpreter_2.expression.Expression;
import designmode.behave.interpreter.interpreter_2.expression.OrExpression;

import java.util.HashMap;
import java.util.Map;

public class AlertRuleExpression {
    private Expression expression;

    public AlertRuleExpression(String expression) {
        this.expression = new OrExpression(expression);
    }

    public boolean interpret(Map<String,Long> stats){
        return expression.interpret(stats);
    }

    public static void main(String[] args) {
        String rule = "key1 > 100 && key2 < 1000 || key3 == 200";
        AlertRuleExpression alertRuleExpression = new AlertRuleExpression(rule);
        Map stats = new HashMap<>(); stats.put("key1", 101l); stats.put("key3", 121l); stats.put("key4", 88l);
        boolean alert = alertRuleExpression.interpret(stats);
        System.out.println(alert);
    }
}
