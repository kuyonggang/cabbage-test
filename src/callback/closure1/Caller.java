/**
 * @ProjectName CallBackAndClosure
 * @FileName Caller.java
 * @PackageName:callback.closure
 * @author YoungerKu
 * @date 2018年1月3日上午10:33:42
 * @since 1.0.0
 * @Copyright (c) 2018,GS ###@unisguard.com All Rights Reserved.
 */
package callback.closure1;

/**
 * 回调类与回调方法
 *
 * @author YoungerKu
 * @date 2018年1月3日 上午10:33:42
 * @since 1.0.0
 */
public class Caller {

	private Incrementable callbackReference;
	
	public Caller(Incrementable callbackReference) {
		this.callbackReference = callbackReference;
	}
	
	void go() {
		this.callbackReference.increment();
	}
}
