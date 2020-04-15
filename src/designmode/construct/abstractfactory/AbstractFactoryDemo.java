package designmode.construct.abstractfactory;

import designmode.construct.abstractfactory.product.IBook;
import designmode.construct.abstractfactory.product.IGame;
import designmode.construct.abstractfactory.product.IProduct;

/**
 * 类名称：AbstractFactoryDemo<br>
 * 类描述：<br>
 * 创建时间：2020年04月14日<br>
 *
 * @author kuyonggang
 * @version 1.0.0
 */
public class AbstractFactoryDemo {
    public static void main(String[] args) {
        //IFactory fc = new FactoryOne();
        //要想生成另一组实例只需要更换具体工厂即可.
        IFactory fc = new FactoryTwo();
        IBook book = fc.createBook();
        IGame game = fc.createGame();
        IProduct product = fc.createProduct();
        book.method1();
        game.method1();
        product.method1();
    }
}
