package ThreadDemo;
//模拟倒计时
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestSleep {

    public static void main(String[] args) throws InterruptedException {
        Date startTime = new Date(System.currentTimeMillis());//获取系统当前时间

        while (true){
            Thread.sleep(1000);
            System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
            startTime = new Date(System.currentTimeMillis());//更新当前时间
        }
    }
}
