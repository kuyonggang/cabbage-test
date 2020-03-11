/**
 * 
 */
package algorithm.recursion;

import java.util.Arrays;
import java.util.List;

/**
 * 类名称：RevertString<br>
 * 类描述：<br>
 * 创建时间：2020年1月7日上午11:39:01<br>
 *
 * @author YoungerKu
 * @version	1.0.0
*/
public class RevertString {

    /**
     * TODO(描述这个方法）
     * 
     * 修改记录: 无
     *
     * @author YoungerKu
     * @createTime 2020年1月7日上午11:39:01
     * @param args
     */
    public static void main(String[] args) {
        String originalStr = "123456789";
        System.out.println(revertStr1(originalStr));
    }

    /**
     * 方法一
     *
     * @author YoungerKu
     * @createTime 2020年1月7日上午11:52:06
     * @param originalStr
     * @return String 反转后的字符串
     */
    private static String revertStr1(String originalStr) {
        char[] originalChar = originalStr.toCharArray();
        int length = originalChar.length;
        char[] charList = new char[length];
        for (int i = length-1;i>=0;i--) {
            charList[length-1-i] = originalChar[i];
        }
        return new String(charList);
    }

    /**
     * 方法一
     *
     * @author YoungerKu
     * @createTime 2020年1月7日上午11:52:06
     * @param originalStr
     * @return String 反转后的字符串
     */
    private static String revertStr2(String originalStr) {
        char[] originalChar = originalStr.toCharArray();
        List<char[]> list = Arrays.asList(originalChar);
        int length = originalChar.length;
        char[] charList = new char[length];
        for (int i = length-1;i>=0;i--) {
            charList[length-1-i] = originalChar[i];
        }
        return new String(charList);
    }
}
