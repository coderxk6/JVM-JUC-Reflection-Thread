package JUC;
//加法计数器
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println("集齐七龙珠，召换神龙！");
        });
        for (int i = 1; i <= 7; i++) {
            final int tmp = i;//jdk1.8前必须加final
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"收集"+tmp+"龙珠");

                try {
                    cyclicBarrier.await();//等待
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
