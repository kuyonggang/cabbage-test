/*
 */
package jvm;
/**
 * 字符串常用操作测试
 * @author YoungerKu 2018年6月7日 下午2:22:01
 */
public class StringTest {

    public static void main(String[] args) {
        
        String str1 = "hello";
        String str11 = "he" + "llo";//java有常量优化机制，在编译时就变成了“hello”
        String str3 = "he" + new String("llo");
        String str2 = "hello".intern();
        String str4 = new String("hello");
        System.out.println(str1 == str11);//true
        System.out.println(str1 == str4); //false
        System.out.println(str1.equals(str4));//true
        System.out.println(str1 == str4.intern());//true
        System.out.println(str1 == str2);//true
        System.out.println(str1 == str3);//false
        System.out.println(str1 == str3.intern());//true
        
        //Java语言提供对字符串串联符号（”+”）和其他对象到字符串的转换的特殊支持。字符串串联是通过 StringBuilder（或 StringBuffer）类及其 append 方法实现的，字符串转换是通过toString方法实现的。
        //在本题中，先在常量池中创建”ab“，地址指向s1,再创建”abc”，指向s2。对于s3，先创建StringBuilder（或 StringBuffer）对象，
        //通过append连接得到“abc”,再调用toString()转换得到的地址指向s3。故(s3==s2)为false.
        String s1="ab";
        String s2="abc";
        String s3=s1+"c";
        System.out.println(s3==s2);//false
        System.out.println(s3.equals(s2));//true
        
        /**
         *  1，concat的计算效率比+效率高
         *  2，concat只适用string和string的拼接，+适用于string和任何对象拼接
         *  3，在少量的字符串拼接时，使用concat或+都行，如果是大量的数据拼接，建议使用StringBuffer或StringBuilder
         */
        str1 = "what";
        str2 = str1.concat(" a nice day");//源码最后一行：return new String(buf, true);
        System.out.println("what a nice day".equals(str2));//true
        System.out.println("what a nice day" == str2);//false
        System.out.println("what a nice day"==str2.intern());//true
        
    }
}
