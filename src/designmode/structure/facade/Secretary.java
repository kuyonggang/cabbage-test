package designmode.structure.facade;

/**
 * 类名称：Secretary<br>
 * 类描述：秘书-外观角色<br>
 * 创建时间：2020年04月14日<br>
 *
 * @author kuyonggang
 * @version 1.0.0
 */
public class Secretary {
    private Driver driver = new Driver();
    private Hotel hotel = new Hotel();
    private Airport airport = new Airport();
    //安排出差
    public void travel(String to,int days){
        airport.bookTicket("扬州", to);
        driver.drive("泰州机场");
        hotel.bookRook(days);
    }
}
