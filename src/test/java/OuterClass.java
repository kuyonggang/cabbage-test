/**
 * @ProjectName MyJavaTest
 * @FileName OuterClass.java
 * @PackageName:test.java
 * @author YoungerKu
 * @date 2018年3月14日下午4:20:31
 * @since 1.0.0
 * @Copyright (c) 2018,GS kuyonggang@unisguard.com All Rights Reserved.
 */
package test.java;

/**
 * 此处添加类OuterClass的描述信息
 *
 * @author YoungerKu
 * @date 2018年3月14日 下午4:20:31
 * @since 1.0.0
 */
public class OuterClass {
	
	private class interClass {
		public interClass() {
			System.out.println("inner Class Created");
		}
	}
	
	public OuterClass() {
		interClass in = new interClass();
		System.out.println("outer Class Created");
	}

	public static void main(String[] args) {
		OuterClass outer = new OuterClass();
	}
}
