package ThreadDemo;
//创建线程方式2：实现runnable接口，重写run方法，执行线程需要丢入runnable接口实现类，调用start方法。
public class Thread2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("调用run:"+i);
        }
    }

    public static void main(String[] args) {
        //创建runnable接口的实现对象
        Thread2 thread2 = new Thread2();
        //创建线程对象，通过线程对象来开启我们的线程，代理
        new Thread(thread2).start();
        for (int i = 0; i < 20; i++) {
            System.out.println("调用main:"+i);
        }
    }
}
