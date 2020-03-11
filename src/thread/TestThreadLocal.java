package thread;
/**
 * @ProjectName my-thread
 * @FileName TestThreadLocal.java
 * @PackageName:
 * @author YoungerKu
 * @date 2018年5月31日上午10:56:38
 * @since 1.0.0
 * @Copyright (c) 2018,sinochem All Rights Reserved.
 */

/**
 * 此处添加类TestThreadLocal的描述信息
 *
 * @author YoungerKu
 * @date 2018年5月31日 上午10:56:38
 * @since 1.0.0
 */
public class TestThreadLocal {

	ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
	ThreadLocal<String> stringLocal = new ThreadLocal<String>();

	public void set() {
		longLocal.set(Thread.currentThread().getId());
		stringLocal.set(Thread.currentThread().getName());
	}

	public long getLong() {
		return longLocal.get();
	}

	public String getString() {
		return stringLocal.get();
	}

	public static void main(String[] args) throws InterruptedException {
		final TestThreadLocal test = new TestThreadLocal();
		test.set();
		System.out.println(test.getLong());
		System.out.println(test.getString());

		Thread thread1 = new Thread(){
			public void run() {
				test.set();//如果不先set会报空指针异常
				System.out.println(test.getLong());
				System.out.println(test.getString());
			};
		};
		thread1.start();
		thread1.join();

		System.out.println(test.getLong());
		System.out.println(test.getString());
	}

}
