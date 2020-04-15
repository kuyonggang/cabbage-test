package designmode.construct.abstractfactory.product.impl;

import designmode.construct.abstractfactory.product.IBook;

/**
 * 类名称：Book<br>
 * 类描述：抽象产品具体类<br>
 * 创建时间：2020年04月14日<br>
 *
 * @author kuyonggang
 * @version 1.0.0
 */
public class Book implements IBook {
    String company = "";
    String bookName = "";
    public Book(String company,String bookName) {
        this.company = company;
        this.bookName = bookName;
    }
    @Override
    public void method1() {
        System.out.print("我们是"+company+"公司,我们发行的书是"+bookName);
        System.out.println("this is book method1 by "+this.getClass().getName());
    }

    @Override
    public void method2() {
        System.out.print("我们是"+company+"公司,我们发行的书是"+bookName);
        System.out.println("this is book method2 by "+this.getClass().getName());
    }

}
