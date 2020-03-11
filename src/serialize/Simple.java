/**
 * @ProjectName MyJavaTest
 * @FileName Simple.java
 * @PackageName:com.serializable
 * @author YoungerKu
 * @date 2018年4月5日下午5:15:39
 * @since 1.0.0
 * @Copyright (c) 2018,sinochem All Rights Reserved.
 */
package serialize;

import java.io.Serializable;
import java.util.Map;

/**
 * @author YoungerKu
 * @date 2018年4月5日 下午5:15:39
 * @since 1.0.0
 */
public class Simple implements Serializable{
	
	/**
     * 
     */
    private static final long serialVersionUID = -615710083532770L;
    
    private String name;
	private int age;
	private static int height;
	private Map<String,Integer> map;
	public Simple(){
	}
	public Simple(String name,int age,Map<String,Integer> map){
		this.name = name;
		this.age = age;
		this.map = map;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Map<String, Integer> getMap() {
		return map;
	}

	public void setMap(Map<String, Integer> map) {
		this.map = map;
	}
    /**
     * @return the height
     */
    public static int getHeight() {
        return height;
    }
    /**
     * @param height the height to set
     */
    public static void setHeight(int height) {
        Simple.height = height;
    }
	
}
