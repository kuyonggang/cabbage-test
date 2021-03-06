/*
 */
package reflect;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 类Param.java的实现描述：TODO 类实现描述 
 * @author Younger 2018年11月1日 下午5:46:40
 */
public class Param<T1,T2> {

    class A{}
    
    class B extends A{}
    
    private Class<T1> entityClass;

    protected Param() {
        Type type = getClass().getGenericSuperclass();  
        System.out.println("getClass() == " + getClass());  
        System.out.println("type = " + type);  
        Type trueType = ((ParameterizedType)type).getActualTypeArguments()[0];  
        System.out.println("trueType1 = " + trueType);  
        trueType = ((ParameterizedType)type).getActualTypeArguments()[1];  
        System.out.println("trueType2 = " + trueType);  
        this.entityClass = (Class<T1>)trueType;  
        System.out.println("entityClass = " + entityClass);
        
        B t = new B();  
        type = t.getClass().getGenericSuperclass();
        System.out.println("A is B's super class :" + ((ParameterizedType)type).getActualTypeArguments().length);
    }
}

class MyClass {

}

class MyInvoke {

}
