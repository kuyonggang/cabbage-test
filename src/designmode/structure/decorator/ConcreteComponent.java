package designmode.structure.decorator;

/**
 * 类名称：ConcreteComponent<br>
 * 类描述：具体装饰目标实现<br>
 * 创建时间：2020年04月14日<br>
 *
 * @author kuyonggang
 * @version 1.0.0
 */
public class ConcreteComponent implements Component {
    @Override
    public void operation() {
        System.out.println("简单的执行。。。");
    }
}
