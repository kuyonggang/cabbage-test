/*
 */
package jvm;
/**
 * 类JVMTest.java的实现描述：TODO 类实现描述 
 * @author Younger 2018年11月25日 下午10:38:04
 */
public class JVMTest {

    public static void main(String[] args) {
//        byte[] b = new byte[4 * 1024 * 1024];
//        System.out.println("分配了4M空间给数组");
        System.out.println("最大内存："+ Runtime.getRuntime().maxMemory()/1024/1024 + "M");
        System.out.println("可用内存：" + Runtime.getRuntime().freeMemory()/1024/1024 + "M");
        System.out.println("已使用内存：" + Runtime.getRuntime().totalMemory()/1024/1024 + "M");
    }
}
