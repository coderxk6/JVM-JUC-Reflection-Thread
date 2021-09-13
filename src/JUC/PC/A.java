package JUC.PC;

/**
 * 线程之间的通信问题：生产者和消费者问题。 等待唤醒，通知唤醒
 * 线程交替执行   A B C D操作同一个变量   num = 0
 * A num+1
 * B num-1
 */

public class A {
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

class Data{
    private int num = 0;
    //+1
    public synchronized void increment() throws InterruptedException {
        while (num!=0){     //while替换if
           this.wait();//等待
        }
        num++;
        System.out.println(Thread.currentThread().getName()+"=>"+num);
        this.notifyAll();//通知其他线程，+1完毕
    }

    public synchronized void decrement() throws InterruptedException {
        while (num==0){
            this.wait();
        }
        num--;
        System.out.println(Thread.currentThread().getName()+"=>"+num);
        this.notifyAll();
    }
}
