package javaLang;

import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;

/**
 * 测试CopyOnWriteArraySet用法，可以在不同线程之间实现数据的隔离
 */
public class CopyOnWriteSetTest {

    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArraySet<Integer> copyOnWriteArraySet = new CopyOnWriteArraySet();
        copyOnWriteArraySet.add(23);
        copyOnWriteArraySet.add(24);
        copyOnWriteArraySet.add(25);

        Thread thread0 = new Thread(() -> {
            for (Integer n : copyOnWriteArraySet) {
                System.out.println(Thread.currentThread().getName() + "->" + n);
            }
            System.out.println(Thread.currentThread().getName() + "开始写入数据");
            for (int i = 0; i < 5; i++) {
//                try {
//                    TimeUnit.SECONDS.sleep(3L);
//                } catch (InterruptedException e) { }
                copyOnWriteArraySet.add(i);
            }
            for (Integer n : copyOnWriteArraySet) {
                System.out.println(Thread.currentThread().getName() + "->" + n);
            }
            System.out.print("\n");
        });
        thread0.start();
        thread0.join();
        /**
         * 如果thread0结束之后才开始thread1，copyOnWriteArraySet中的元素就是thread0线程结束之后的元素
         * 如果thread0结束之前已经开始了thread1，那么copyOnWriteArraySet中的元素还是初始化时的元素
         */
        Thread thread1 = new Thread(() -> {
            for (Integer n : copyOnWriteArraySet) {
                try {
                    TimeUnit.SECONDS.sleep(3L);
                } catch (InterruptedException e) { }
                System.out.println(Thread.currentThread().getName() + "->" + n);
            }
            System.out.print("\n");
        });

        thread1.start();
    }
}
