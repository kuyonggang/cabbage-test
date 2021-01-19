package designmode.construct.builder.demo1;

/**
 * 类名称：CellPhoneDirector<br>
 * 类描述： 导演者(Director)
 *    负责安排构建的顺序<br>
 * 创建时间：2020年04月14日<br>
 *
 * @author kuyonggang
 * @version 1.0.0
 */
public class CellPhoneDirector {
    private Builder cellPhoneBuilder = null;

    public Mate7 buildMate7() {
        cellPhoneBuilder = new Mate7Builder();
        cellPhoneBuilder.buildCPU();
        cellPhoneBuilder.buildRAM();
        cellPhoneBuilder.buildScreen();
        cellPhoneBuilder.buildBattery();
        cellPhoneBuilder.buildFacade();
        cellPhoneBuilder.buildOthers();
        return (Mate7) cellPhoneBuilder.getPhone();
    }

    public Mx4Pro buildMx4Pro(){
        cellPhoneBuilder = new Mx4ProBuilder();
        cellPhoneBuilder.buildCPU();
        cellPhoneBuilder.buildRAM();
        cellPhoneBuilder.buildScreen();
        cellPhoneBuilder.buildBattery();
        cellPhoneBuilder.buildFacade();
        cellPhoneBuilder.buildOthers();
        return (Mx4Pro) cellPhoneBuilder.getPhone();
    }
}
