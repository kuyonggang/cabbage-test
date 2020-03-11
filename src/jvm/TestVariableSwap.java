/**
 * 
 */
package jvm;
/**
 * 类名称：TestVariableSwap<br>
 * 类描述：<br>
 * 创建时间：2019年10月13日下午9:19:31<br>
 *
 * @author YoungerKu
 * @version	1.0.0
*/
public class TestVariableSwap {

    public static void main(String[] args) {
//        Integer t1=2,t2=3;
//        Integer t1=129,t2=130;
//        String t1 = "zhangsan",t2="lisi";
        String t1=new String("zhangsan");
        String t2=new String("lisi");
        System.out.println("t1:"+t1+" t2:"+t2);
        swap(t1,t2);
        System.out.println("t1:"+t1+" t2:"+t2);
    }
    
    private static void swap(Integer t1,Integer t2) {
        Integer tmp = t2;
        t2 = t1;
        t1 = tmp;
        System.out.println("t1:"+t1+" t2:"+t2);
    }
    
    private static void swap(String t1,String t2) {
        String tmp = t2;
        t2 = t1;
        t1 = tmp;
        System.out.println("t1:"+t1+" t2:"+t2);
    }
}
