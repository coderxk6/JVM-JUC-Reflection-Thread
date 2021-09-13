package JUC;
//线程是一个单独的资源类，没有任何附属操作。

//并发：多线程操作同一个资源类，把资源类丢入线程
public class SaleTicketDemo1 {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        new Thread(()->{
            for (int i = 0; i < 30; i++) {
                ticket.sale();
            }
        },"A").start();

        new Thread(()->{
            for (int i = 0; i < 30; i++) {
                ticket.sale();
            }
        },"B").start();

        new Thread(()->{
            for (int i = 0; i < 30; i++) {
                ticket.sale();
            }
        },"C").start();
    }

}
//资源OOP
class Ticket{
    private int number = 50;
    //卖票方式
    //synchronized本质：队列、锁
    public synchronized void sale(){
        if (number > 0){
            System.out.println(Thread.currentThread().getName()+"卖了"+(number--)+"剩余"+number+"票");
        }
    }
}
