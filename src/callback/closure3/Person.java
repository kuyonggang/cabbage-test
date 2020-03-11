package callback.closure3;

/**
 * 类名称：Person<br>
 * 类描述：<br>
 * 创建时间：2020年03月06日<br>
 *
 * @author kuyonggang
 * @version 1.0.0
 */
public class Person {
    public static void main(String[] args) {
        //买一箱牛奶
        Milk m = new Milk();
        Active haveMeals = m.HaveMeals();

        //没事喝一瓶
        haveMeals.drink();
        //有事喝一瓶
        haveMeals.drink();

        //看看还剩多少？
        m.currentNum();
    }
}
