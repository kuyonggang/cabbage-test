/**
 * @ProjectName MyJavaTest
 * @FileName OriginalSerializable.java
 * @PackageName:com.serializable
 * @author YoungerKu
 * @date 2018年4月5日下午5:13:58
 * @since 1.0.0
 * @Copyright (c) 2018,sinochem All Rights Reserved.
 */
package serialize;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author YoungerKu
 * @date 2018年4月5日 下午5:13:58
 * @since 1.0.0
 */
public class OriginalSerializable {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		long start =System.currentTimeMillis();
		setSerializableObject();
		System.out.println("java原生序列化时间:" + (System.currentTimeMillis() - start) + " ms" );
		start =System.currentTimeMillis();
		getSerializableObject();
		System.out.println("java原生反序列化时间:" + (System.currentTimeMillis() - start) + " ms");
	}

	public static void setSerializableObject() throws IOException{
		FileOutputStream fo = new FileOutputStream("D:/file2.bin");
		ObjectOutputStream so = new ObjectOutputStream(fo);
		for (int i = 0; i < 1; i++) {
			Map<String,Integer> map = new HashMap<String, Integer>(2);
			map.put("zhang0", i);
			map.put("zhang1", i);
			Simple simple = new Simple("zhang"+i,(i+1),map);
			simple.setHeight(178);
			so.writeObject(simple);
			so.flush();
			so.writeObject(simple);
			so.flush();
		}
		so.close();
	}

	public static void getSerializableObject(){
		FileInputStream fi;
		try {
			fi = new FileInputStream("D:/file2.bin");
			ObjectInputStream si = new ObjectInputStream(fi);
			Simple simple =null;
			Simple.setHeight(180);
			while((simple=(Simple)si.readObject()) != null){
			    //打印出的height为在代码中修改后的值（180）
				System.out.println(simple.getAge() + "->" + simple.getName() + "->" + simple.getHeight());
			}
			fi.close();
			si.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
