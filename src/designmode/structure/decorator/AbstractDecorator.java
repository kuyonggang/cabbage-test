package designmode.structure.decorator;

/**
 * 类名称：AbstractDecorator<br>
 * 类描述：<br>
 * 创建时间：2020年04月14日<br>
 *
 * @author kuyonggang
 * @version 1.0.0
 */
public abstract class AbstractDecorator implements Component{
    private Component component;
    public AbstractDecorator(Component component){
        this.component = component;
    }

    @Override
    public void operation() {
        this.component.operation();
    }

}
