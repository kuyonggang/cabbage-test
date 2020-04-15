package designmode.construct.abstractfactory;

import designmode.construct.abstractfactory.product.IBook;
import designmode.construct.abstractfactory.product.IGame;
import designmode.construct.abstractfactory.product.IProduct;
import designmode.construct.abstractfactory.product.impl.Book;
import designmode.construct.abstractfactory.product.impl.Game;
import designmode.construct.abstractfactory.product.impl.Product;


/**
 * 类名称：FactoryOne<br>
 * 类描述：具体工厂
 *      在工厂内部指定好,而不需要再调用时去指定.<br>
 * 创建时间：2020年04月14日<br>
 *
 * @author kuyonggang
 * @version 1.0.0
 */
public class FactoryOne implements IFactory {

    @Override
    public IBook createBook() {
        return new Book("A","java核心技术");
    }

    @Override
    public IGame createGame() {
        return new Game("A","DOTA");
    }

    @Override
    public IProduct createProduct() {
        return new Product("A","BEATS");
    }
}
