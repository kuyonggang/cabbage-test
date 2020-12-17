package reflect;

import java.util.Arrays;

public class TestConstructor {

    public static void main(String[] params) {
        System.out.println(Arrays.toString(TestClass.class.getConstructors()));
        System.out.println(Arrays.toString(TestClass.class.getDeclaredConstructors()));
        /*
            运行结果：
[public reflect.TestConstructor$TestClass(reflect.TestConstructor,long)]
[private reflect.TestConstructor$TestClass(reflect.TestConstructor,short), protected reflect.TestConstructor$TestClass(reflect.TestConstructor,int), public reflect.TestConstructor$TestClass(reflect.TestConstructor,long)]
         */
    }

    public class TestClass {
        private TestClass(short i){
        }

        protected TestClass(int i){
        }

        public TestClass(long l){
        }
    }
}
