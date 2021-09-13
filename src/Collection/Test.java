package Collection;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List list = new ArrayList();
        Student s1 = new Student("小明", 22);
        Student s2 = new Student("小红", 20);
        Student s3 = new Student("小风", 23);
        Student s4 = new Student("小风", 23);
        Student s5 = new Student("小强", 23);

        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);
        for (int i = 0; i <list.size() ; i++) {
            System.out.println("索引："+i+"对应的元素："+list.get(i));
        }

        for (Object o : list) {
            System.out.println(list);
        }
    }
}
