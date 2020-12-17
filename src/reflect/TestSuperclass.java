package reflect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.AnnotatedType;

public class TestSuperclass {

    public static void main(String[] args) {
        System.out.println(SubClass.class.getSuperclass());
        System.out.println(SubClass.class.getGenericSuperclass());
        AnnotatedType annotatedSuperclass = SubClass.class.getAnnotatedSuperclass();
        System.out.println(annotatedSuperclass);

        /**
         * 运行结果：
         * class reflect.TestSuperclass$SuperClass
         * class reflect.TestSuperclass$SuperClass
         * sun.reflect.annotation.AnnotatedTypeFactory$AnnotatedTypeBaseImpl@6f94fa3e
         */
    }

    @TestAnnotation
    public class SuperClass<T>{

    }

    public class SubClass extends SuperClass{

    }

    @Target(ElementType.TYPE_USE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface TestAnnotation{

    }
}

