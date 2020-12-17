package reflect;

/**
 * asSubclass(Class<U>):Class<? extends U>
 * 把该类型(子类)转换为目标类型(父类)。
 * isAssignableFrom(Class<?>):boolean
 * 测试该类型(父类)是否为目标类型(子类)的父类。
 */
public class TestAssignable {

    public static void main(String[] params) {
        test(Object.class);
        System.out.println("---------------------------------");
        test(TestClass.class);

        /*
            输出结果：
            test方法 -> 获得一个clazz，但不确定它是否为TestSuperClass类型或其子类
            test方法 -> 这个clazz不是TestSuperClass类型或其子类
            ---------------------------------
            test方法 -> 获得一个clazz，但不确定它是否为TestSuperClass类型或其子类
            test方法 -> 确认这个clazz是TestSuperClass类型或其子类
         */
    }

    public static Class<? extends TestSuperClass> test(Class<?> clazz){
        System.out.println("test -> 获得一个clazz，但不确定它是否为TestSuperClass类型或其子类");
        if(TestSuperClass.class.isAssignableFrom(clazz)){
            System.out.println("test -> 确认这个clazz是TestSuperClass类型或其子类");
            return clazz.asSubclass(TestSuperClass.class);
        }
        System.out.println("test -> 这个clazz不是TestSuperClass类型或其子类");
        return null;
    }

    public class TestSuperClass {
    }

    public class TestClass extends TestSuperClass {
    }
}
