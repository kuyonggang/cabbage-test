package javaLang;

import java.util.HashSet;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;

/**
 * 系统运行报错：
 * Exception in thread "Thread-1" java.util.ConcurrentModificationException
 */
public class HashSetTest {

    public static void main(String[] args) {

        HashSet<Integer> hashSet = new HashSet();
        hashSet.add(23);
        hashSet.add(24);
        hashSet.add(25);

        Thread thread0 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    TimeUnit.SECONDS.sleep(3L);
                } catch (InterruptedException e) { }
                hashSet.add(i);
            }
            for (Integer n : hashSet) {
                System.out.println(Thread.currentThread().getName() + "->" + n);
            }
            System.out.print("\n");
        });
        thread0.start();

        Thread thread1 = new Thread(() -> {
            for (Integer n : hashSet) {
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
