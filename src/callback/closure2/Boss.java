/**
 * @ProjectName CallBackAndClosure
 * @FileName Boss.java
 * @PackageName:callback.closure2
 * @author YoungerKu
 * @date 2018年1月3日上午11:03:09
 * @since 1.0.0
 * @Copyright (c) 2018,GS ###@unisguard.com All Rights Reserved.
 */
package callback.closure2;

/**
 * 使用了闭包 和 回调
 * 
 * @author YoungerKu
 * @date 2018年1月3日 上午11:03:09
 * @since 1.0.0
 */
public class Boss {
	
	private Employee e;

	public void notifyBoss() {
		System.out.println("做完了，请检查！");
	}
	
	/**
	 * 接口+内部类 实现闭包
	 *
	 * @author YoungerKu
	 * @date 2018年1月3日 上午11:08:59
	 * @since 1.0.0
	 */
	public class Task implements SuperTask{

		public Task(Employee e) {
			Boss.this.e = e;
		}
		
		/**
		 * (non-Javadoc)
		 * @see callback.closure2.SuperTask#doSomething()
		 */
		@Override
		public void doSomething() {
			e.doSomethind();
			//工作做完之后回调通知方法通知老板
			notifyBoss();
		}
	}
	
	/**
	 * 传入一个员工对象
	 *
	 * @param e
	 * @return 
	 * @date  2018年1月3日上午11:07:41
	 * @since 1.0.0
	*/
	SuperTask getTask(Employee e) {
		return new Task(e);
	}
}

interface SuperTask{
	public void doSomething();
}