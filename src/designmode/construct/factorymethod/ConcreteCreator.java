package designmode.construct.factorymethod;

/**
 * 类名称：ConcreteCreator<br>
 * 类描述：具体工厂角色接口<br>
 * 创建时间：2020年04月14日<br>
 *
 * @author kuyonggang
 * @version 1.0.0
 */
public class ConcreteCreator implements Creator {

    @Override
    public <T extends Product> T factory(Class<T> c) {
        Product product = null;
        try {
            product = (Product) Class.forName(c.getName()).newInstance();
        } catch (InstantiationException | IllegalAccessException
                | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (T)product;
    }

}
