
package algorithm.recursion;

import java.util.Scanner;

/**
 * 类名称：Factorial<br>
 * 类描述：递归实现阶乘<br>
 * 亦即n!=1×2×3×...×(n-1)n。阶乘亦可以递归方式定义：0!=1，n!=(n-1)!×n。
 * 创建时间：2020年1月2日上午10:26:26<br>
 *
 * @author YoungerKu
 * @version	1.0.0
*/
public class Factorial {
    
    private static int computeFactorial(int n){
        if(n == 1) {
            return 1;
        }
        return n*computeFactorial(n-1);
    }

    public static void main(String[] args) {
        while(true) {
            System.out.println("请输入运算数值(退出请输0)：");
            Scanner scanner = new Scanner(System.in);
            int num = scanner.nextInt();
            if(num == 0) {
                System.out.println("程序成功退出！！！");
                System.exit(0);
            }
            System.out.println("运算结果："+computeFactorial(num));
        }
    }
}
