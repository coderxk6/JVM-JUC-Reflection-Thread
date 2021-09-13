package JUC.PC;
//lock

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程之间的通信问题：生产者和消费者问题。 等待唤醒，通知唤醒
 * 线程交替执行   A B C D操作同一个变量   num = 0
 * A num+1
 * B num-1
 */

public class B {
    public static void main(String[] args) {
        Data data = new Data();
        new Thread(()->{
            for (int i=0;i<10; i++){
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();

        new Thread(()->{
            for (int i=0;i<10; i++){
                try {
                    data.decrement();;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();

        new Thread(()->{
            for (int i=0;i<10; i++){
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();

        new Thread(()->{
            for (int i=0;i<10; i++){
                try {
                    data.decrement();;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D").start();
    }
}

class Data2{
    private int num = 0;

    Lock lock = new ReentrantLock();//
    Condition condition = lock.newCondition();//
    //+1
    public synchronized void increment() throws InterruptedException {
        lock.lock();
        try {
            while (num!=0){
               condition.await();   //等待
            }
            num++;
            System.out.println(Thread.currentThread().getName()+"=>"+num);
            condition.signalAll();  //通知其他线程，+1完毕
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public synchronized void decrement() throws InterruptedException {
        lock.lock();
        try {
            while (num == 0) {
                condition.await();
            }
            num--;
            System.out.println(Thread.currentThread().getName() + "=>" + num);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
