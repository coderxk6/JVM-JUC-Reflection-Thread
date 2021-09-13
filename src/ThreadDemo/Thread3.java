package ThreadDemo;
//多线程同时操作同一个对象-->买火车票例子

//发现问题：多个线程操作同一个资源的情况下，线程不安全，数据紊乱

public class Thread3 implements Runnable {
    //票数
    private int tickeNums = 10;
    @Override
    public void run() {
        while (true){
            if (tickeNums<=0){
                break;
            }
            //模拟延时
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"拿到了第"+tickeNums--+"票");

        }
    }

    public static void main(String[] args) {
        Thread3 thread3 = new Thread3();
        new Thread(thread3,"小明").start();
        new Thread(thread3,"小王").start();
        new Thread(thread3,"黄牛").start();

    }
}
