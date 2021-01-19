package designmode.construct.builder.demo1;

/**
 * 类名称：Mate7Builder<br>
 * 类描述：<br>
 * 创建时间：2020年04月14日<br>
 *
 * @author kuyonggang
 * @version 1.0.0
 */
public class Mate7Builder implements Builder {

    AbstractCellPhone mate7 = new Mate7();

    @Override
    public void buildCPU() {
        mate7.setCpu("华为研发的芯片");
    }

    @Override
    public void buildRAM() {
        mate7.setRam("3G内存");
    }

    @Override
    public void buildScreen() {
        mate7.setScreen("六寸高清屏");
    }

    @Override
    public void buildBattery() {
        mate7.setBattery("4100毫安大容量电池");
    }

    @Override
    public void buildFacade() {
        mate7.setFacade("琥珀金");
    }

    @Override
    public void buildOthers() {
        mate7.setOthers("后背指纹识别");
    }

    @Override
    public AbstractCellPhone getPhone() {
        return mate7;
    }
}
