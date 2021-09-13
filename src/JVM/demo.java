package JVM;

public class demo {
    public static void main(String[] args) {
        //返回虚拟机试图使用的最大内存
        long max = Runtime.getRuntime().maxMemory();//字节1024*1024
        //返回JVM的初始化总内存
        long total = Runtime.getRuntime().totalMemory();

        System.out.println("max"+max+"字节\t"+(max/(double)1024/1024)+"MB");
        System.out.println("total"+total+"字节\t"+(total/(double)1024/1024)+"MB");
    }
    //OOM:
        //1.尝试扩大堆内存看结果
        //2.分析内存，看一下哪个地方出现了问题（专业工具）

    //-Xms1024m -Xmx1024m -XX:+PrintGCDetails
}
