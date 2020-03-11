/*
 */
package serialize;
/**
 * 类Student.java的实现描述：TODO 类实现描述 
 * @author Younger 2019年1月7日 上午9:46:48
 */
public class Student {

    static String sex;
    private transient String name;
    private int age;
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }
    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }
    /**
     * @return the sex
     */
    public static String getSex() {
        return sex;
    }
    /**
     * @param sex the sex to set
     */
    public static void setSex(String sex) {
        Student.sex = sex;
    }
    
}
