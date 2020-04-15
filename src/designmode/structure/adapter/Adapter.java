package designmode.structure.adapter;

/**
 * 类名称：Adapter<br>
 * 类描述：适配器<br>
 * 创建时间：2020年04月14日<br>
 *
 * @author kuyonggang
 * @version 1.0.0
 */
public class Adapter extends Adaptee implements Target {
    @Override
    public void request() {
        System.out.println("适配器改良开始");
        super.specificRequest();
        System.out.println("适配器改良结束");
    }
}

