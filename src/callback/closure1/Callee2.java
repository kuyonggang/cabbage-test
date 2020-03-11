/**
 * @ProjectName CallBackAndClosure
 * @FileName Callee2.java
 * @PackageName:callback.closure
 * @author YoungerKu
 * @date 2018年1月3日上午10:30:37
 * @since 1.0.0
 * @Copyright (c) 2018,GS ###@unisguard.com All Rights Reserved.
 */
package callback.closure1;

/**
 * @author YoungerKu
 * @date 2018年1月3日 上午10:30:37
 * @since 1.0.0
 */
public class Callee2 extends MyIncrement {

	private int i = 0;
	
	public void increment() {
		super.increment();
		i++;
		System.out.println("Callee2 increment()被调用"+i+"次");
	}
	
	/**
	 * 内部实现类Closure，实现Incrementable接口
	 * 接口与内部类结合实现闭包
	 * 
	 * @author YoungerKu
	 * @date 2018年1月3日 上午10:31:51
	 * @since 1.0.0
	 */
	private class Closure implements Incrementable{

		/**
		 * (non-Javadoc)
		 * @see callback.closure1.Incrementable#increment()
		 */
		@Override
		public void increment() {
			//回调Callee2中的方法
			Callee2.this.increment();
		}
		
	}
	
	/**
	 * 返回接口引用
	 *
	 * @return 
	 * @date  2018年1月3日上午10:32:57
	 * @since 1.0.0
	*/
	Incrementable getCallbackReference() {
		return new Closure();
	}
}
