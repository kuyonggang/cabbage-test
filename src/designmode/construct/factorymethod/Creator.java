package designmode.construct.factorymethod;

/**
 * 类名称：Creator<br>
 * 类描述：工厂方法模式-抽象工厂角色接口<br>
 * 创建时间：2020年04月14日<br>
 *
 * @author kuyonggang
 * @version 1.0.0
 */
public interface Creator {

    /**
     * 创建一个产品对象,输入参数类型(特定接口的子类)可以自行设置
     * 只能创建实现Product接口的类的对象
     */
    public <T extends Product> T factory(Class<T> c);
}
