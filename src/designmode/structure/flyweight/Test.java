package designmode.structure.flyweight;

/**
 * 类名称：Test<br>
 * 类描述：<br>
 * 创建时间：2020年04月14日<br>
 *
 * @author kuyonggang
 * @version 1.0.0
 */
public class Test {
    public static void main(String[] args) {
        //内部状态在获取对象时加载
        IPrize prize1 = PrizeFactory.getInstance("超级法拉利一辆");
        //外部状态在调用方法时传入
        prize1.LuckDraw("没中奖");
        System.out.println("-----------------------------");
        IPrize prize2 = PrizeFactory.getInstance("小米手机一部");
        prize2.LuckDraw("中奖");
    }
}
