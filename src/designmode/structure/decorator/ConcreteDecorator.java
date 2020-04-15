package designmode.structure.decorator;

/**
 * 类名称：ConcreteDecorator<br>
 * 类描述：具体的装饰者<br>
 * 创建时间：2020年04月14日<br>
 *
 * @author kuyonggang
 * @version 1.0.0
 */
public class ConcreteDecorator extends AbstractDecorator {
    public ConcreteDecorator(Component component){
        super(component);
    }

    private void decorate(){
        System.out.println("对方法进行装饰..");
    }

    @Override
    public void operation() {
        decorate();
        super.operation();
    }
}
