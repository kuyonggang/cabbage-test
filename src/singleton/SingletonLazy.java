package singleton;
/**
 * 
 */
/**
 * 类名称：SingletonEnum<br>
 * 类描述：<br>
 * 创建时间：2020年2月16日下午8:51:30<br>
 *
 * @author Administrator
 * @version	1.0.0
*/
public class SingletonLazy {

    private SingletonLazy() {}
    

    private static class EnumTool{
      private static final SingletonLazy singletonLazy = new SingletonLazy();
    }
    
    public static final SingletonLazy getInstance() {
        return EnumTool.singletonLazy;
    }
    public static void main(String[] args) {
       System.out.println(SingletonLazy.getInstance() == SingletonLazy.getInstance());
    }
}


