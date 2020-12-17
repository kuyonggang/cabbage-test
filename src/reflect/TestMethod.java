package reflect;

import java.util.Arrays;

public class TestMethod {

    public static void main(String[] params) {
        System.out.println(Arrays.toString(TestClass.class.getMethods()));
        System.out.println("----------------------------------");
        System.out.println(Arrays.toString(TestClass.class.getDeclaredMethods()));

        /*
            运行结果：
            [public void Test$TestClass.test(long), public void Test$TestSuperClass.superTest(long), 省略Object的方法……]
            ----------------------------------
            [public void Test$TestClass.test(long), protected void Test$TestClass.test(int), private void Test$TestClass.test(short)]
         */
    }

    public class TestSuperClass {
        private void superTest(short i){

        }

        protected void superTest(int i){

        }

        public void superTest(long l){

        }
    }

    public class TestClass extends TestSuperClass {
        private void test(short i){
        }

        protected void test(int i){
        }

        public void test(long l){
        }
    }
}
