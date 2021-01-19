package designmode.construct.builder.demo1;

/**
 * 类名称：CellPhoneDemo<br>
 * 类描述：<br>
 * 创建时间：2020年04月14日<br>
 *
 * @author kuyonggang
 * @version 1.0.0
 */
public class CellPhoneDemo {
    public static void main(String[] args) {
        CellPhoneDirector director = new CellPhoneDirector();
        System.out.println("构建Mate7");
        Mate7 mate7 = director.buildMate7();
        System.out.println(mate7);    //查看详情
        System.out.println("构建Mx4Pro");
        Mx4Pro mx4Pro = director.buildMx4Pro();
        System.out.println(mx4Pro);    //查看详情
    }
}
