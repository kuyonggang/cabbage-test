/*
 */
package serialize;

import com.alibaba.fastjson.JSON;

/**
 * Json序列化的时候，对象的静态变量和transient变量无法进行序列化
 * 
 * @author Younger 2019年1月7日 上午9:49:24
 */
public class JsonSerializable {

    public static void main(String[] args) {
        Student stu = new Student();
        stu.setName("zhangsan");
        stu.setAge(18);
        Student.sex = "男";
        String stuJson = JSON.toJSONString(stu);
        System.out.println("json:"+stuJson);
    } 
}
