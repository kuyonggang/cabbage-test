package designmode.construct.abstractfactory;

import designmode.construct.abstractfactory.product.IBook;
import designmode.construct.abstractfactory.product.IGame;
import designmode.construct.abstractfactory.product.IProduct;
import designmode.construct.abstractfactory.product.impl.Book;
import designmode.construct.abstractfactory.product.impl.Game;
import designmode.construct.abstractfactory.product.impl.Product;


/**
 * 类名称：FactoryTwo<br>
 * 类描述：另一个具体工厂-生产另一组产品线
 *   在工厂内部指定好,而不需要再调用时去指定.<br>
 * 创建时间：2020年04月14日<br>
 *
 * @author kuyonggang
 * @version 1.0.0
 */
public class FactoryTwo implements IFactory {
    @Override
    public IBook createBook() {
        return new Book("B","系统架构设计师");
    }

    @Override
    public IGame createGame() {
        return new Game("B","LOL");
    }

    @Override
    public IProduct createProduct() {
        return new Product("B","红米");
    }

}
