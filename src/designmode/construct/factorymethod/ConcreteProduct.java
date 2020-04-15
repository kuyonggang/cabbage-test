package designmode.construct.factorymethod;

/**
 * 类名称：ConcreteProduct<br>
 * 类描述：具体产品角色接口<br>
 * 创建时间：2020年04月14日<br>
 *
 * @author kuyonggang
 * @version 1.0.0
 */
public class ConcreteProduct implements Product {

    @Override
    public void method1() {
        System.out.println("this is method one by class"+this.getClass().getName());
    }

    @Override
    public void method2() {
        System.out.println("this is method two by class"+this.getClass().getName());

    }
}
