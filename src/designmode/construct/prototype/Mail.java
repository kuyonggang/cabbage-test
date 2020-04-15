package designmode.construct.prototype;

import lombok.Data;

/**
 * 类名称：Mail<br>
 * 类描述：实现clone接口,实现了clone方法,是实现克隆的关键<br>
 * 创建时间：2020年04月14日<br>
 *
 * @author kuyonggang
 * @version 1.0.0
 */
@Data
public class Mail implements Cloneable {
    //收件人
    private String receiver;
    //邮件标题
    private String subject;
    //称谓
    private String appellation;
    //邮件内容
    private String contxt;
    //尾部
    private String tail;
    //构造函数
    public Mail(String subject,String contxt) {
        this.subject = subject;
        this.contxt = contxt;
    }
    //克隆方法
    public Mail clone() {
        Mail mail = null;
        try {
            mail=(Mail) super.clone();
            System.out.println(super.toString());   //super指的是被调用的那个对象
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return mail;
    }
}
