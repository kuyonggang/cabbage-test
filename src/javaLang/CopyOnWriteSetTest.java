package javaLang;

import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;

/**
 * 测试CopyOnWriteArraySet用法，可以在不同线程之间实现数据的隔离
 *
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
//            System.out.println(Thread.currentThread().getName() + "开始写入数据");
//            for (int i = 0; i < 5; i++) {
////                try {
////                    TimeUnit.SECONDS.sleep(3L);
////                } catch (InterruptedException e) { }
//                copyOnWriteArraySet.add(i);
//            }
            copyOnWriteArraySet.remove(25);
            try {
                TimeUnit.SECONDS.sleep(3L);
            } catch (InterruptedException e) { }
            for (Integer n : copyOnWriteArraySet) {
                System.out.println(Thread.currentThread().getName() + "->" + n);
            }
            System.out.print("\n");
        });
        thread0.start();
//        thread0.join();
        /**
         * 如果thread0中对copyOnWriteArraySet修改（新增or删除）结束之后才开始thread1中的遍历，
         * thread1中的copyOnWriteArraySet中的元素就是thread0线程修改之后的元素，反之就是修改前的元素
         */
        Thread thread1 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1L);
            } catch (InterruptedException e) { }
            for (Integer n : copyOnWriteArraySet) {
                System.out.println(Thread.currentThread().getName() + "->" + n);
            }
            System.out.print("\n");
        });

        thread1.start();
    }
}
