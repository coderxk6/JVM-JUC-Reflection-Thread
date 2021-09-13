package syn;
//死锁：多个线程互相抱着对方需要的资源，然后形成僵局
public class DeadLock {
    public static void main(String[] args) {
        Makeup q1 = new Makeup(0, "灰姑凉");
        Makeup q2 = new Makeup(0, "白雪公主");
        q1.start();
        q2.start();
    }
}

//口红
class Lipstick{

}
//镜子
class Mirror{

}
class Makeup extends Thread{
    //需要的资源只有一份，用static保证只有一份
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    int choice;//选择
    String girlName;//使用化妆品的女孩

    Makeup(int choice,String girlName){
        this.choice = choice;
        this.girlName = girlName;
    }

    @Override
    public void run() {
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //化妆，互相持有对方的锁，就是需要拿到对方的资源
    private void makeup() throws InterruptedException {
        if (choice==0) {
            synchronized (lipstick) {
                System.out.println(this.girlName + "获得口红的锁");
                Thread.sleep(1000);
            }
            synchronized (mirror) {
                System.out.println(this.girlName + "获得镜子的锁");
            }
        }else{
                synchronized (mirror) {
                    System.out.println(this.girlName + "获得镜子的锁");
                    Thread.sleep(2000);

                }
            synchronized (lipstick) {
                System.out.println(this.girlName + "获得口红的锁");
            }

        }
    }
}
