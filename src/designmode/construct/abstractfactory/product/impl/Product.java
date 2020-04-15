package designmode.construct.abstractfactory.product.impl;

import designmode.construct.abstractfactory.product.IProduct;

/**
 * 类名称：Product<br>
 * 类描述：<br>
 * 创建时间：2020年04月14日<br>
 *
 * @author kuyonggang
 * @version 1.0.0
 */
public class Product implements IProduct {
    String company = "";
    String produceName = "";
    public Product(String company,String produceName) {
        this.company = company;
        this.produceName = produceName;
    }
    @Override
    public void method1() {
        System.out.print("我们是"+company+"公司,我们的卖产品是"+produceName);
        System.out.println("this is Product method1 by " + this.getClass().getName());
    }

    @Override
    public void method2() {
        System.out.print("我们是"+company+"公司,我们的卖产品是"+produceName);
        System.out.println("this is Product method2 by "+this.getClass().getName());
    }
}
