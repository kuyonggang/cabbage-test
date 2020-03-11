/**
 * 
 */
package jvm;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 类名称：HashTest<br>
 * 类描述：<br>
 * 创建时间：Mar 19, 20193:53:38 PM<br>
 *
 * @author Younger
 * @version	1.0.0
*/
public class HashTest {

    /**
     * TODO(描述这个方法）
     * 
     * 修改记录: 无
     *
     * @author Younger
     * @createTime Mar 19, 20193:53:38 PM
     * @param args
     */
    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
//        map.put(null, "test");
        map.put("bb", "tt");
        System.out.println(map.get(null));
        ConcurrentHashMap<String, String> cMap = new ConcurrentHashMap<>();
        cMap.put("aa", "bb");
        map = new Hashtable<>();
        map.put("aa","bb");
//        map.put("aa", null);
//        System.out.println(map.get(null));
        System.out.println(getNum(1));
    }
    
    public static int getNum(int i) {
        try {
            System.out.println(i);
            return 4;
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println(33);
            return 3;
        }
    }

}
