import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @ProjectName MyJavaTest
 * @FileName LittleTest.java
 * @PackageName:
 * @author YoungerKu
 * @date 2018年4月7日上午9:53:01
 * @since 1.0.0
 * @Copyright (c) 2018,sinochem All Rights Reserved.
 */

/**
 * 此处添加类LittleTest的描述信息
 *
 * @author YoungerKu
 * @date 2018年4月7日 上午9:53:01
 * @since 1.0.0
 */
public class LittleTest {

	/**
	 * 此处添加main方法的描述信息
	 *
	 * @param args 
	 * @date  2018年4月7日上午9:53:01
	 * @since 1.0.0
	*/
	public static void main(String[] args) {
		Date date = new Date(LocalDateTime.now().atZone(ZoneId.systemDefault())
                .toInstant().toEpochMilli() - (10 * 1000));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf.format(date));
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.println("methodName:"+methodName);
	}

}
