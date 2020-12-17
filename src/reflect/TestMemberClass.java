package reflect;

import java.util.Arrays;

public class TestMemberClass {

    public static void main(String[] params) {
        System.out.println(Arrays.toString(TestMemberClass.class.getClasses()));
        System.out.println("---------------------------------");
        System.out.println(Arrays.toString(TestMemberClass.class.getDeclaredClasses()));

        /*
            输出结果：
            [class Test$TestClass$TestMemberClass3, class Test$TestSuperClass$TestSuperMemberClass3]
            ---------------------------------
            [class Test$TestClass$TestMemberClass1, class Test$TestClass$TestMemberClass2, class Test$TestClass$TestMemberClass3]
         */
    }


    public class TestSuperClass {

        private class TestSuperMemberClass1 {

        }

        protected class TestSuperMemberClass2 {

        }

        public class TestSuperMemberClass3 {

        }
    }

    public class TestClass extends TestSuperClass {

        private class TestMemberClass1 {

        }

        protected class TestMemberClass2 {

        }

        public class TestMemberClass3 {

        }

    }
}
