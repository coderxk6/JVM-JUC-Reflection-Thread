package ThreadDemo;

//测试join方法（插队）
public class TestJoin implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("VIP线程来也！" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //启动我们的线程
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();

        //主线程
        for (int i = 0; i < 1000; i++) {
//            if (i == 20) {
//                thread.join();//插队
//            }
            System.out.println("main" + i);

        }
    }
}

