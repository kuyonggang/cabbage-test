/**
 * 
 */
package test.java;

import java.util.Arrays;

/**
 * 类名称：PossibleReordering<br>
 * 类描述：测试指令重排序<br>
 * 创建时间：2020年1月2日下午6:06:59<br>
 *
 * @author YoungerKu
 * @version	1.0.0
*/
public class PossibleReordering {
    static int x = 0, y = 0;
    static int a = 0, b = 0;

    public PossibleReordering() {}

    public static void main(String[] args) throws InterruptedException {
        int result[] = new int[4];
        for(int i = 0; i < 100000; i++){
            Thread one = new Thread(new Runnable() {
                @Override
                public void run() {
                    a = 1;
                    x = b;
                }
            });
    
            Thread two = new Thread(new Runnable() {
                
                @Override
                public void run() {
                    b = 1;
                    y = a;
                }
            });
            x=y=a=b=0;
            one.start();
            two.start();
            one.join();
            two.join();
            //注意，此时线程one和two均以结束，其对x，y的修改已经写回到主内存
            int r = (x << 1) | (y);
            result[r]++;
        }
        System.out.println(Arrays.toString(result));
    }
}
