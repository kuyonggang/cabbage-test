package designmode.construct.abstractfactory;

import designmode.construct.abstractfactory.product.IBook;
import designmode.construct.abstractfactory.product.IGame;
import designmode.construct.abstractfactory.product.IProduct;

/**
 * 类名称：IFactory<br>
 * 类描述：抽象工厂-创建多个产品而不是单独的一个
 *   为创建一组相关或相互依赖的对象提供一个接口，而且无需指定他们的具体类。<br>
 * 创建时间：2020年04月14日<br>
 *
 * @author kuyonggang
 * @version 1.0.0
 */
public interface IFactory {
    public IBook createBook();
    public IGame createGame();
    public IProduct createProduct();
}
