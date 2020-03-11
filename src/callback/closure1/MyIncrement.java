/**
 * @ProjectName CallBackAndClosure
 * @FileName MyIncrement.java
 * @PackageName:callback.closure
 * @author YoungerKu
 * @date 2018年1月3日上午10:29:23
 * @since 1.0.0
 * @Copyright (c) 2018,GS ###@unisguard.com All Rights Reserved.
 */
package callback.closure1;

/**
 * @author YoungerKu
 * @date 2018年1月3日 上午10:29:23
 * @since 1.0.0
 */
public class MyIncrement {

	public void increment() {
		System.out.println("MyIncrement increment()被调用啦！");
	}
	
	static void f(MyIncrement mi) {
		mi.increment();
	}
}
