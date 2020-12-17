package reflect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;

public class TestSuperInterface {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(TestClass.class.getInterfaces()));
        System.out.println(Arrays.toString(TestClass.class.getGenericInterfaces()));
        System.out.println(Arrays.toString(TestClass.class.getAnnotatedInterfaces()));
        /**
         * [interface reflect.TestInterface$SubInterface]
         * [reflect.TestInterface.reflect.TestInterface$SubInterface<java.lang.Integer>]
         * [sun.reflect.annotation.AnnotatedTypeFactory$AnnotatedParameterizedTypeImpl@5451c3a8]
         */
    }

    public interface SuperInterface{}

    public interface SubInterface<T> extends SuperInterface{}

    public class TestClass implements @TestAnnotation SubInterface<Integer>{

    }

    @Target(ElementType.TYPE_USE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface TestAnnotation{}
}
