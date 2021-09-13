package JVM;

/**
 * 双亲委派机制
 */
public class Car {
    public static void main(String[] args) {
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();

        //不同的实例
        System.out.println("car1 hashCode="+car1.hashCode());
        System.out.println("car2 hashCode="+car2.hashCode());
        System.out.println("car3 hashCode="+car3.hashCode());

        //同一个类模版
        Class<? extends Car> aClass1 = car1.getClass();
        Class<? extends Car> aClass2 = car2.getClass();
        Class<? extends Car> aClass3 = car3.getClass();

        System.out.println("aClass1 hashCode="+aClass1.hashCode());
        System.out.println("aClass2 hashCode="+aClass2.hashCode());
        System.out.println("aClass3 hashCode="+aClass3.hashCode());

        //由于类模版都是一个，以下就选择一个进行测试
        ClassLoader classLoader = aClass1.getClassLoader();

        System.out.println(classLoader);  //AppClassLoader

        System.out.println(classLoader.getParent());  //ExtClassLoader  所在位置：\jre\lib\ext

        System.out.println(classLoader.getParent().getParent());  //null 1.不存在  2.java程序获取不到  所在位置：rt.jar

    }
}
