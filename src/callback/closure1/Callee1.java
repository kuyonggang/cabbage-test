/**
 * @ProjectName CallBackAndClosure
 * @FileName Callee1.java
 * @PackageName:callback.closure
 * @author YoungerKu
 * @date 2018年1月3日上午10:27:36
 * @since 1.0.0
 * @Copyright (c) 2018,GS ###@unisguard.com All Rights Reserved.
 */
package callback.closure1;

/**
 * 实现类Callee1
 *
 * @author YoungerKu
 * @date 2018年1月3日 上午10:27:36
 * @since 1.0.0
 */
public class Callee1 implements Incrementable {

	private int i = 0;
	
	/**
	 * (non-Javadoc)
	 * @see callback.closure1.Incrementable#increment()
	 */
	@Override
	public void increment()
	{
		i++;
		System.out.println("Callee1 increment()被调用 " + i + " 次");
	}

}
