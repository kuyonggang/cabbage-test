package designmode.structure.facade;

/**
 * 类名称：Boss<br>
 * 类描述：老板调用外观角色(秘书)<br>
 * 创建时间：2020年04月14日<br>
 *
 * @author kuyonggang
 * @version 1.0.0
 */
public class Boss {
    public static void main(String[] args) {
        Secretary secretary = new Secretary();
        System.out.println("老板告诉秘书要到美国出差10天");
        secretary.travel("美国", 10);
    }
}
