package littleTest;

import com.alibaba.fastjson.JSON;
import lombok.Data;

@Data
public class Parent {
    private String name;
    private String age;
}

@Data
class Son1 extends Parent {
    private String grade;
    private String weight;
}

@Data
class Son2 extends Parent {
    private String height;
}

class test{
    public static void main(String[] args) {
        Son1 son1 = new Son1();
        son1.setWeight("12");
        son1.setGrade("二年级");
        son1.setName("张三");
        son1.setAge("23");
        System.out.println(JSON.toJSONString(son1));

        Parent p1 = new Parent();
        p1.setName("李四");
        p1.setAge("53");
        System.out.println(JSON.toJSONString(p1));

        p1 = (Parent)son1;
        System.out.println(JSON.toJSONString(p1));

        son1 = (Son1)p1;
        System.out.println(JSON.toJSONString(son1));

        Integer a = 236;
        Integer b = 236;
        System.out.println(a==b);

        int c1 = 236;
        int c2 = 236;
        System.out.println(c1 == c2);
    }
}
