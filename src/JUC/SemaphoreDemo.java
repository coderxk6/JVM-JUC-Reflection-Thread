package JUC;
/**
 * Semaphore信号量
 * 作用：多个资源互斥使用，并发限流，控制最大线程数！
 */

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
//模拟抢车位 6抢3
public class SemaphoreDemo {
    public static void main(String[] args) {
        //线程数量：3    限流
        Semaphore semaphore = new Semaphore(3);
        for (int i = 1; i <=6; i++) {

            new Thread(() -> {
                try {
                    semaphore.acquire();//得到
                    System.out.println(Thread.currentThread().getName()+" 抢到了停车位");
                    TimeUnit.SECONDS.sleep(2);//停2秒
                    System.out.println(Thread.currentThread().getName()+" 离开了停车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();//释放
                }

            }, String.valueOf(i)).start();
        }
    }
}
