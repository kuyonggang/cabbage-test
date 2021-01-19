package designmode.construct.builder.demo1;

/**
 * 类名称：AbstractBuilder<br>
 * 类描述：抽象建造者角色（Builder）
 *        规范产品的组成部分<br>
 * 创建时间：2020年04月14日<br>
 *
 * @author kuyonggang
 * @version 1.0.0
 */
public interface Builder {

    public void buildCPU();
    public void buildRAM();
    public void buildScreen();
    public void buildBattery();
    public void buildFacade();
    public void buildOthers();
    public AbstractCellPhone getPhone();

}
