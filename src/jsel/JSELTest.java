package jsel;

import java.util.Date;
import java.util.HashMap;

import org.xidea.el.Expression;
import org.xidea.el.ExpressionFactory;
import org.xidea.el.impl.ExpressionFactoryImpl;

public class JSELTest implements Runnable {

	public static ExpressionFactory factory = ExpressionFactoryImpl.getInstance();

	/**
	 * 表达式函数（与对象绑定时，可以不申明为　static）
	 */
	public int testAdd(int i, int j) {
		return i + j;
	}

	public void testExpression() {
		Expression el = factory.create("12 * 60 + 100");
		Object result1 = el.evaluate();
		System.out.println("result1");
		System.out.println(result1);
	}

	public void testMapContext() {
		Expression el = factory.create("var1 +  ( (2+1) * var2) + obj.testAdd(1,2)");
		Object result21 = el.evaluate("var1", 123, "var2", 456, "obj", this);
		System.out.println("result21:" + result21);
		// 通过方式传递变量
		HashMap<String, Object> context = new HashMap<String, Object>();
		context.put("var1", 111);
		context.put("var2", 222);
		context.put("obj", this); // 设置对象
		Object result22 = el.evaluate(context);
		System.out.println("result22:" + result22);
	}

	public void testFunction() {
		Expression el = factory.create("100 + testAdd(1,2)");
		Object result3 = el.evaluate(this);
		System.out.println("result3");
		System.out.println(result3);
	}

	public static void main(String[] args) {
		JSELTest test = new JSELTest();
		//test.testExpression();
		//test.testMapContext();
		//test.testFunction();
		Expression el = test.factory.create("交易金額 > 2000");
		Date bDate = new Date();
		for(int i = 0 ;i <= 1 ; i++){
			Object obj = el.evaluate("交易金額", 3001);
			System.out.println(obj);
		}
		Date cDate = new Date();
	}


	public void testT(){
		Expression el = JSELTest.factory.create("交易金額 > 3000 && obj.test(登錄次數,10)  &&  2 in [6,2,1]");
		Date bDate = new Date();
		int i = 0;
		for(i = 0 ;i <= 2000 ; i++){
			el.evaluate(
					"交易金額", 5000,
					"登錄次數", 50,
					"obj", JSELTest.class);			
		}
		Date cDate = new Date();
		System.out.println(cDate.getTime() - bDate.getTime());		
	}


	/**
	 * 本地函数，测试规则表达式是否支持调用任意本地函数
	 */
	public static boolean test(int a, int b){
		return a > b;
	}

	public static int testReturnVal() {
		return 10;
	}
	
	public void run() {
		Expression el = JSELTest.factory.create("交易金額 > 3000 &&   obj.test(登錄次數,10)  &&  2 in [6,2,1]   ");
		Date bDate = new Date();
		int i = 0;
		for( i = 0 ;i <= 2000 ; i++){
			System.out.println(el.evaluate(
					"交易金額", 5000,
					"登錄次數", i,
					"obj", JSELTest.class));			
		}
		Date cDate = new Date();
		System.out.println(cDate.getTime() - bDate.getTime());		
	}
}