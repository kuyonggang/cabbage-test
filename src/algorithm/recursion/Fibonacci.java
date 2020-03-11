/**
 * 
 */
package algorithm.recursion;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 类名称：Fibonacci<br>
 * 类描述：斐波那契数列（Fibonacci sequence），又称黄金分割数列、因数学家列昂纳多·斐波那契（Leonardoda Fibonacci）以兔子繁殖为例子而引入，故又称为“兔子数列”，指的是这样一个数列：1、1、2、3、5、8、13、21、34、……
 * 在数学上，斐波那契数列以如下被以递推的方法定义：F(1)=1，F(2)=1, F(n)=F(n-1)+F(n-2)（n>=3，n∈N*）<br>
 * 创建时间：2020年1月2日上午10:49:05<br>
 *
 * @author YoungerKu
 * @version	1.0.0
*/
public class Fibonacci {
    private long i = 0;
    private Map<Long,Long> middleCache = new HashMap<>();
    public long computeFibWithCache(long n) {
        System.out.println("执行次数："+(++i));
        if(n == 1) {
            return 0;
        }
        if(n == 2) {
            return 1;
        }
        
        Long fibVal = middleCache.get(n);
        if(fibVal != null) {
            return fibVal;
        }
        long result = computeFibWithCache(n-1) + computeFibWithCache(n-2);
        middleCache.put(n,result);
        return result;
    }
    
    public long computeFib(long n) {
        System.out.println("执行次数："+(++i));
        if(n == 1) {
            return 0;
        }
        if(n == 2) {
            return 1;
        }
        long result = computeFib(n-1) + computeFib(n-2);
        return result;
    }

    /**
     * 修改记录: 无
     *
     * @author YoungerKu
     * @createTime 2020年1月2日上午10:49:05
     * @param args
     */
    public static void main(String[] args) {
        while(true) {
            System.out.println("请输入运算数值(退出请输0)：");
            Scanner scanner = new Scanner(System.in);
            int num = scanner.nextInt();
            if(num == 0) {
                System.out.println("程序成功退出！！！");
                System.exit(0);
            }
            Fibonacci fi = new Fibonacci();
            System.out.println("运算结果："+fi.computeFib(num));
            System.out.println("优化运算结果："+fi.computeFibWithCache(num));
        }
       
    }

}
