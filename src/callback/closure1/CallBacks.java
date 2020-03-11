/**
 * @ProjectName CallBackAndClosure
 * @FileName CallBacks.java
 * @PackageName:callback.closure
 * @author YoungerKu
 * @date 2018年1月3日上午10:35:24
 * @since 1.0.0
 * @Copyright (c) 2018,GS ###@unisguard.com All Rights Reserved.
 */
package callback.closure1;

/**
 * 此处添加类CallBacks的描述信息
 *
 * @author YoungerKu
 * @date 2018年1月3日 上午10:35:24
 * @since 1.0.0
 */
public class CallBacks {

	public static void main(String[] args) {
		Callee1 callee1 = new Callee1();
		Caller caller = new Caller(callee1);
		caller.go();
		caller.go();
		
		Callee2 callee2 = new Callee2();
		MyIncrement.f(callee2);
		
		//Caller对象可以使用此引用回调Callee2类。
		Incrementable callbackRef = callee2.getCallbackReference();
		caller = new Caller(callbackRef);
		caller.go();
		caller.go();
	}
}
