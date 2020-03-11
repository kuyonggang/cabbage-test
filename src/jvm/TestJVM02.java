/*
 */
package jvm;
/**
 * -Xms20m -Xmx20m -Xmn1m -XX:SurvivorRatio=2 -XX:+PrintGCDetails -XX:+UseSerialGC
 * XX:SurvivorRatio=2 新生代中的Eden:s0:s1=2:1:1
 * @author Younger 2018年11月25日 下午10:49:55
 */
public class TestJVM02 {

    public static void main(String[] args) {
        byte[] b = null;
        for(int i=0;i < 10;i++) {
            b = new byte[1024*1024];
        }
    }
}
