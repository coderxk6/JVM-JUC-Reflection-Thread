package annotation;
//自定义注解

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Test03 {
    @MyAnnotation(name="小明",age=20)
    public void test(){}

    @MyAnnotation2("小王")
    public void test2(){}
}

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation{
    //注解的参数：参数类型+参数名()
    String name() default "" ;
    int age();
    int id() default -1;//如果默认-1，代表不存在
    String[] schools() default {"清华","北大"};
}

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2{
    String value();//如果注解只有一个值，可以用value,用时可以省略参数名value
}
