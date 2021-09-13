package JUC;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread myThread = new MyThread();
        FutureTask futureTask = new FutureTask(myThread);//适配类

        new Thread(futureTask,"A").start();

        Integer o = (Integer) futureTask.get();//这个get方法可能会产生阻塞！把它放到最后或者用异步通信处理
        System.out.println(o);
    }
}

class MyThread implements Callable<Integer> {
    @Override
    public Integer call(){
        System.out.println("call()");
        return 1024;
    }
}
