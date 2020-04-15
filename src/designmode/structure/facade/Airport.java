package designmode.structure.facade;

/**
 * 类名称：Airport<br>
 * 类描述：子系统角色-机场<br>
 * 创建时间：2020年04月14日<br>
 *
 * @author kuyonggang
 * @version 1.0.0
 */
public class Airport {
    public void bookTicket(String from,String to){
        System.out.println("订购了从"+from+"到"+to+"的机票");
    }
}
