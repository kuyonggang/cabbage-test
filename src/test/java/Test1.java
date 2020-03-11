/**
 * @ProjectName MyJavaTest
 * @FileName Test1.java
 * @PackageName:test.java
 * @author YoungerKu
 * @date 2018年3月14日下午2:01:05
 * @since 1.0.0
 * @Copyright (c) 2018,GS kuyonggang@unisguard.com All Rights Reserved.
 */
package test.java;

/**
 * 这里要特殊考虑String，以及Integer、Double等几个基本类型包装类，它们都是immutable类型，
 * 因为没有提供自身修改的函数，每次操作都是新生成一个对象，所以要特殊对待，可以认为是和基本数据类型相似，传值操作。
 * （1）基本数据类型传值，对形参的修改不会影响实参；
 * （2）引用类型传引用，形参和实参指向同一个内存地址（同一个对象），所以对参数的修改会影响到实际的对象；
 * （3）String, Integer, Double等immutable的类型特殊处理，可以理解为传值，最后的操作不会修改实参对象。
 * 
 * @author YoungerKu
 * @date 2018年3月14日 下午2:01:05
 * @since 1.0.0
 */
public class Test1 {
	
	public static void main(String[] args) {
		int a = 0;
		String s = new String("sss");
		Integer b = new Integer(2);
		testFun(a,s,b);
		System.out.println(a);
		System.out.println(s);
		System.out.println(b);
		StringBuffer sb = new StringBuffer("hello");
		//StringBuffer和StringBuilder等是引用传递
		test(sb);
		System.out.println(sb);
	}

	private static void test(StringBuffer sb) {
		sb.append(" world");
	}

	private static void testFun(int a, String s, Integer b) {
		a = 12;
		s = new String("ee");
		b = new Integer(3);
	}

}
