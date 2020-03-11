/**
 * 
 */
package callback;
/**
 * 类名称：CallBackImpl<br>
 * 类描述：<br>
 * 创建时间：2020年1月15日下午4:29:18<br>
 *
 * @author YoungerKu
 * @version	1.0.0
*/
public class CallBackImpl implements CallBack {

    /* (non-Javadoc)
     * @see callback.CallBack#callBack()
     */
    @Override
    public void callBack() {
        System.out.println("回调一下！！！");
    }

}
