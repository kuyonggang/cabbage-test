package littleTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        // asList返回的是Arrays内部类，并没有实现集合的修改方法
        Integer[] s = {1,2};
        List<Integer> statusList = Arrays.asList(s);
        System.out.println(statusList);
        System.out.println(statusList.contains(1));
        System.out.println(statusList.contains(3));
        s[0] = 0;
        System.out.println(s[0]);
        //下面的语句会抛出UnsupportedOperationException
//        statusList.add(3);
//        System.out.println(statusList.contains(3));

        //=====================================================

        List<String> bookList = new ArrayList<>();
        bookList.add("我");
        bookList.add("爱");
        bookList.add("我");
        bookList.add("家");
        bookList.add("乡");
        bookList.add(1,"大");
        System.out.println(bookList);
        bookList.set(0,"小");
        System.out.println(bookList);
        List<String> luyaoBookList = bookList.subList(3, 5);
        System.out.println(bookList);
        System.out.println(luyaoBookList);
        // 修改原集合的值会影响到子集合
//        bookList.set(3,"故");
//
//        System.out.println(bookList);
//        System.out.println(luyaoBookList);

        // 往原集合添加元素，子集合会抛出异常
//        bookList.add("我");
//
//        System.out.println(bookList);
//        System.out.println(luyaoBookList);

        //修改子集合的值会影响到原集合
//        luyaoBookList.set(1,"你");
//
//        System.out.println(bookList);
//        System.out.println(luyaoBookList);

        // 修改子集合的结构，会影响原集合
        luyaoBookList.add("你");

        System.out.println(bookList);
        System.out.println(luyaoBookList);
    }
}
