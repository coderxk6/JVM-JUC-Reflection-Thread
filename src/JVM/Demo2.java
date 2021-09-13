package JVM;

import java.util.Random;

public class Demo2 {
    public static void main(String[] args) {
        String str = "java";

        while (true){
            str += str +new Random().nextInt(88888888)+new Random().nextInt(99999999);
        }
    }
}
