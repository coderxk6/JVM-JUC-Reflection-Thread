package syn;
//不安全的买票（有负数）
public class UnsafeBuyTicket {

    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();

        new Thread(buyTicket,"小明").start();
        new Thread(buyTicket,"小红").start();
        new Thread(buyTicket,"黄牛").start();
    }
}

class  BuyTicket implements Runnable{
    private int ticketNums = 10;//票
    boolean flag = true;//外部停止方式
    @Override
    //synchronized锁
    public synchronized void run() {
        //买票
        while (flag) {
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private void buy() throws InterruptedException {

        if (ticketNums<=0){
            flag = false;
            return;
        }
        //模拟延时
        Thread.sleep(100);
        System.out.println(Thread.currentThread().getName()+"拿到了："+ticketNums--);
    }
}

