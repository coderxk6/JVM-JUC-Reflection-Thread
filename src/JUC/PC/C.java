package JUC.PC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class C {
    public static void main(String[] args) {
        Data3 data3 = new Data3();
        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                data3.printA();
            }
        },"A").start();

        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                data3.printB();
            }
        },"B").start();

        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                data3.printC();
            }
        },"C").start();

    }
}

class Data3{
    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();
    int num = 1;//A-1  B-2  C-3
    public void printA() {
        lock.lock();
        try {//业务-> 判断-> 执行-> 通知
            while (num != 1) {
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName() + "->AAAAAAAA");
            //唤醒指定的B
            num = 2;
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
        public void printB(){
            lock.lock();
            try {//业务-> 判断-> 执行-> 通知
                while (num !=2){
                    condition2.await();
                }
                System.out.println(Thread.currentThread().getName()+"->BBBBBBBBB");
                //唤醒指定的C
                num = 3;
                condition3.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            
    }

    public void printC(){
        lock.lock();
        try {//业务-> 判断-> 执行-> 通知
            while (num !=3){
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName()+"->CCCCCCCCC");
            //唤醒指定的C
            num = 1;
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

}