package designmode.construct.singleton;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 类名称：CounterSingleton<br>
 * 类描述：<br>
 * 创建时间：2020年04月13日<br>
 *
 * @author kuyonggang
 * @version 1.0.0
 */
public class CounterSingleton {
    //懒汉式加载
    private static CounterSingleton singleton = new CounterSingleton();
    //私有构造,防止生成对象
    private CounterSingleton() {
    }
    //获取类
    public static CounterSingleton getInstance() {
        return singleton;
    }
    //对象的统计变量
    public volatile int count = 0;
    //懒汉式对象的方法
    public synchronized void inc() {
        //加访问量
        count++;
        System.out.println("线程:"+Thread.currentThread()+",对象:"+this+",运行结果:CounterSingleton.count=" + CounterSingleton.getInstance().getCount());
    }
    //获取计数的值
    public int getCount() {
        return count;
    }

//    public static void main(String[] args) throws InterruptedException {
//        long time_s = System.currentTimeMillis();
//        CountDownLatch latch = new CountDownLatch(10);
//        //同时启动1000个线程，去进行i++计算，看看实际结果
//        for (int i = 0; i < 10; i++) {
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    CounterSingleton.getInstance().inc();
//                    latch.countDown();
//                }
//            }).start();
//        }
//        latch.await();
//        //这里每次运行的值都有可能不同,显示结果可能不为1000,但实际值是1000，因为线程是异步执行的原因(inc方法没有sychonized的话,count就是真的不是1000了)
//        System.out.println("这里不一定是1000,而且不一定在最后。因为线程是异步执行的!"+",对象:"+CounterSingleton.getInstance().toString()+",运行结果:CounterSingleton.count=" + CounterSingleton.getInstance().getCount());
//        System.out.println("耗时:"+(System.currentTimeMillis()-time_s));
//    }

    public static void main(String[] args) throws InterruptedException {
        long time_s = System.currentTimeMillis();
        CyclicBarrier barrier = new CyclicBarrier(10, new Runnable() {
            @Override
            public void run() {
                System.out.println("线程均已达到屏障,执行线程："+Thread.currentThread() + " 线程组："+Thread.currentThread().getThreadGroup());
            }
        });
        //同时启动1000个线程，去进行i++计算，看看实际结果
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    CounterSingleton.getInstance().inc();
                    try {
                        System.out.println(barrier.await());
                        System.out.println("tripe the barrier");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        //这里每次运行的值都有可能不同,显示结果可能不为1000,但实际值是1000，因为线程是异步执行的原因(inc方法没有sychonized的话,count就是真的不是1000了)
        System.out.println("这里不一定是1000,而且不一定在最后。因为线程是异步执行的!"+",对象:"+CounterSingleton.getInstance().toString()+",运行结果:CounterSingleton.count=" + CounterSingleton.getInstance().getCount());
        System.out.println("耗时:"+(System.currentTimeMillis()-time_s));
    }


//    public static void main(String[] args) throws InterruptedException {
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    TimeUnit.SECONDS.sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        thread.start();
//        System.out.println("main线程结束...");
//    }
}