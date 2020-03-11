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
public enum SingletonEnum {

    INSTANCE1,INSTANCE2;
    private final Singleton instance;
    
    SingletonEnum(){
        System.out.println("执行枚举构造方法！！！");
        instance = new Singleton();
    }
    
    public Singleton getSingleton() {
        return instance;
    }
    
    public static void main(String[] args) {
        Singleton singleton1 = SingletonEnum.INSTANCE1.getSingleton();
        Singleton singleton11 = SingletonEnum.INSTANCE1.getSingleton();
        Singleton singleton2 =SingletonEnum.INSTANCE2.getSingleton();
        System.out.println(singleton1 == singleton11);
        System.out.println(singleton2 == singleton1);
    }

}

class Singleton{
}

