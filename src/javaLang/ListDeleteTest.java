package javaLang;

import java.util.ArrayList;
import java.util.List;

public class ListDeleteTest {

    private static List<Integer> list = new ArrayList();

    public static void main(String[] args) {
        list.add(12);
        list.add(13);
        list.add(14);
        list.add(15);
        list.add(16);
        System.out.println("=========迭代遍历时删除元素场景1=========");
        for (int ele : list) {
            //当前遍历的不是倒数第二个元素，所以会出现ConcurrentModificationException错误
            if(ele == 13){
                list.remove(ele);
            }
            System.out.println(ele);
        }
        System.out.println("=========迭代遍历时删除元素场景2=========");
        for (int ele : list) {
            //只有遍历倒数第二个元素的时候，删除元素才不会报错，但是最后一个元素将无法遍历到
            //具体原因可查看集合中的迭代器实现源码
            if(ele == 15){
                list.remove(Integer.valueOf(13));
            }
            System.out.println(ele);
        }
        System.out.println("=========普通for循环时删除元素场景=========");
        for (int i = 0; i < list.size(); i++) {
            Integer ele = list.get(i);
            System.out.println(ele);
            //普通for循环遍历删除元素不会出现异常，同步修改异常仅仅在集合内部迭代器类中会出现，也就是迭代遍历时会出现
            if(ele == 14){
                list.remove(i--);
            }
        }




    }
}
