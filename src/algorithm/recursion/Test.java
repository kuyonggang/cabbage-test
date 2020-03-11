package algorithm.recursion;

/**
 * 类名称：Test<br>
 * 类描述：一个人买汽水，一块钱一瓶汽水，三个瓶盖可以换一瓶汽水，两个空瓶可以换一瓶汽水
 *  问20块钱可以买多少汽水？
 *  哇!华为真的"LOW"这不是在考验小学生吗?侮辱我们的智商啊! 咋一眼一看,额
 *  貌似好像不是那么的简单哈.
 *  沉下心来看看.
 *  首先分析:
 *  一瓶汽水:1soda = 1cap +1bottle;
 *  两个空瓶:2bottle = 1soda;
 *  三个瓶盖:3cap = 1soda;
 *  那么递归退出条件就是: cup<3&&bottle<2 &&soda<1
 *  因为在这个过程中，三个元素soda， cup， bottle都有连续的变化，所以递归调用时要将三个参数都传进去。<br>
 * 创建时间：2020年1月3日下午2:16:51<br>
 * todo：还需进一步完善
 * @author YoungerKu
 * @version	1.0.0
*/
public class Test {

    private static int buy(int total,int bottle,int cap) {
        bottle = bottle%2;
        cap = cap%3;
        bottle += total;
        cap += total;
        if(bottle<2) {
            if(cap<3) {
                return total;
            }else {
                return buy(cap/3,bottle,cap)+total;
            }
        }
        return buy(bottle/2,bottle,cap)+total;
    }

    public static void main(String[] args) {
        int total = buy(5, 0, 0);
        System.out.println(total);
    }

}
