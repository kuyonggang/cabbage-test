package javaLang;

import java.sql.Time;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;

/**
 * CopyOnWriteListTest，可以在不同线程之间实现数据的隔离
 */
public class CopyOnWriteListTest {

    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<Integer> copyOnWriteArraySet = new CopyOnWriteArrayList();
        copyOnWriteArraySet.add(23);
        copyOnWriteArraySet.add(24);
        copyOnWriteArraySet.add(25);

        Thread thread0 = new Thread(() -> {
            for (int i = 0; i < 4; i++) {
                System.out.println(Thread.currentThread().getName() + "->" + copyOnWriteArraySet.get(i) + "->" + copyOnWriteArraySet.size());
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print("\n");
        });
        thread0.start();
//        thread0.join();

        Thread thread1 = new Thread(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            copyOnWriteArraySet.add(1,44);
        });
        thread1.start();
    }
}
