/**
 * 
 */
package callback;
/**
 * 类名称：Caller<br>
 * 类描述：<br>
 * 创建时间：2020年1月15日下午4:30:04<br>
 *
 * @author YoungerKu
 * @version	1.0.0
*/
public class Caller {

    public static void call(CallBack callBack) {
        System.out.println("调用逻辑开始。。。");
        callBack.callBack();
        System.out.println("调用逻辑结束。。。");
    }
    
    public static void main(String[] args) {
        Caller caller = new Caller();
        caller.call(new CallBack() {
            @Override
            public void callBack() {
                System.out.println("进入回调逻辑。。。");
            }   
        });
    }
}
