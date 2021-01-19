package designmode.construct.builder.demo1;

import lombok.Data;

/**
 * 类名称：CellPhone<br>
 * 类描述：抽象产品类
 *        共同的数据类型,继承用<br>
 * 创建时间：2020年04月14日<br>
 *
 * @author kuyonggang
 * @version 1.0.0
 */
@Data
public abstract class AbstractCellPhone {
    private String cpu;    //CPU型号
    private String ram;    //内存
    private String screen;    //屏幕
    private String battery;    //电池
    private String facade;    //外观
    private String others;    //其他部件
}
