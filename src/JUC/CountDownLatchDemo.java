package JUC;

import java.util.concurrent.CountDownLatch;

//减法计数器(倒计时锁)
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <=6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+" Go out ");
                countDownLatch.countDown();//-1
            },String.valueOf(i)).start();
        }
        countDownLatch.await();//等待计数器归零，再向下执行
        System.out.println("Close door");
    }
}
