package designmode.construct.builder;

/**
 * 类名称：Mx4ProBuilder<br>
 * 类描述：Mx4Pro具体建造者(Concrete Builder)
 *   实现抽象建造者方法<br>
 * 创建时间：2020年04月14日<br>
 *
 * @author kuyonggang
 * @version 1.0.0
 */
public class Mx4ProBuilder implements Builder {

    AbstractCellPhone mx4 = new Mx4Pro();

    @Override
    public void buildCPU() {
        mx4.setCpu("三星的CPU");
    }

    @Override
    public void buildRAM() {
        mx4.setRam("3G内存");
    }

    @Override
    public void buildScreen() {
        mx4.setScreen("五点五寸2K高清屏");
    }

    @Override
    public void buildBattery() {
        mx4.setBattery("3300毫安大容量电池");
    }

    @Override
    public void buildFacade() {
        mx4.setFacade("土豪金");
    }

    @Override
    public void buildOthers() {
        mx4.setOthers("360度指纹识别");
    }

    @Override
    public AbstractCellPhone getPhone() {
        return mx4;
    }
}
