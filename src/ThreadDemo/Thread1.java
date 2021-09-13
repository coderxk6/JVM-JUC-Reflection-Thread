package ThreadDemo;
//线程开启不一定立即执行，由cpu调度执行
public class Thread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("调用run:"+i);
        }
    }

    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        thread1.start();
        //thread1.run();
        for (int i = 0; i < 20; i++) {
            System.out.println("调用main:"+i);
        }
    }
}
