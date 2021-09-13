package Demo;

public class StringBuilderDemo {
    public static void main(String[] args) {
        //开始时间
        long start = System.currentTimeMillis();
//        String string = "";
//        for (int i = 0; i <99999 ; i++) {
//            string+=i;
//        }
//        System.out.println(string);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <99999 ; i++) {
            stringBuilder.append(i);
        }
        System.out.println(stringBuilder.toString());

        long end = System.currentTimeMillis();
        System.out.println("用时："+(end-start));
    }
}
