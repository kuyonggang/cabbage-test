/**
 * 
 */
package singleton;
/**
 * 类名称：CasDemo<br>
 * 类描述：<br>
 * 创建时间：2020年1月17日下午7:01:25<br>
 *
 * @author YoungerKu
 * @version	1.0.0
*/

import java.util.concurrent.atomic.AtomicReference;

public class SingletonCAS {

    private static final AtomicReference<SingletonCAS> INSTANCE = new AtomicReference<>();
    private SingletonCAS() {}
    
    public static SingletonCAS getInstance() {
        for(;;) {
            SingletonCAS singleton = INSTANCE.get();
            if(null != singleton) {
                return singleton;
            }
            singleton = new SingletonCAS();
            if(INSTANCE.compareAndSet(null, singleton)) {
                return singleton;
            }
        }
    }
}
