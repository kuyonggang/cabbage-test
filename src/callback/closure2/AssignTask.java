/**
 * @ProjectName CallBackAndClosure
 * @FileName AssignTask.java
 * @PackageName:callback.closure2
 * @author YoungerKu
 * @date 2018年1月3日上午11:09:53
 * @since 1.0.0
 * @Copyright (c) 2018,GS ###@unisguard.com All Rights Reserved.
 */
package callback.closure2;

/**
 * 分配任务
 *
 * @author YoungerKu
 * @date 2018年1月3日 上午11:09:53
 * @since 1.0.0
 */
public class AssignTask {

	public static void main(String[] args) {
		Boss boss = new Boss();
		Employee e = new Employee();
		
		SuperTask task = boss.getTask(e);

		task.doSomething();
	}

}
