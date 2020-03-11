/*
 */
package jvm;
/**
 * 类TestJVM03.java的实现描述：TODO 类实现描述 
 * @author Younger 2018年11月26日 上午11:52:24
 */
public class TestJVM03 {

    private static int count = 0;
    
    //默认深度为10912 -Xss5m:线程所占用的栈空间大小，配置越大栈深度越大
    //栈溢出产生在方法递归调用时
    public static void invoke() {
        try {
            count ++;
            invoke();
        }catch(Throwable e) {
            System.out.println("虚拟机栈最大深度：" + count);
            e.printStackTrace();
        }
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        invoke();
    }

}
