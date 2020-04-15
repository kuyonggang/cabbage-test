package designmode.construct.builder;

/**
 * 类名称：Mx4Pro<br>
 * 类描述：<br>
 * 创建时间：2020年04月14日<br>
 *
 * @author kuyonggang
 * @version 1.0.0
 */
public class Mx4Pro extends AbstractCellPhone{
    public Mx4Pro() {
        System.out.println("这是华为Mx4Pro手机");
    }

    public String toString(){
        return "配置\nCPU:"+this.getCpu()+"\n内存:"+this.getRam()+"\n屏幕大小:"
                +this.getScreen()+"\n电池容量:"+this.getBattery()+"\n外观:"
                +this.getFacade()+"\n其他功能:"+this.getOthers();
    }
}
