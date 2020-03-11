/**
 * 
 */
package jvm.jmm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 类名称：TestConstantPoolLocation<br>
 * 类描述：<br>
 * 创建时间：2020年2月16日下午4:53:40<br>
 *
 * @author Administrator
 * @version	1.0.0
*/
public class TestConstantPoolLocation {


    /**
     * 运行如下代码探究运行时常量池的位置
     * 
     * 修改记录: 无
     *
     * @author Administrator
     * @createTime 2020年2月16日下午4:53:40
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(Arrays.asList(args));
        //用list保持着引用 防止full gc回收常量池
        List<String> list = new ArrayList<String>();
        int i = 0;
        try {
            while(true){
//                System.out.println(i);
                list.add(String.valueOf(i++).intern());
            }
        } catch (Exception e) {
            System.out.println(i);
        }
    }

}
