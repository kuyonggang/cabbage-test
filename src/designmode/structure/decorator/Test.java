package designmode.structure.decorator;

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
        Component component = new ConcreteComponent();
        component.operation();
        // 用装饰者装饰一下
        AbstractDecorator decorator = new ConcreteDecorator(component);
        decorator.operation();
    }
}
