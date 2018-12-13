/**
 * FileName:         JvmTest04.java
 * @Description:     TODO
 * @author:            chenlin
 * @version            V1.0
 * Createdate:      2018年12月11日     上午10:25:40
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018年12月11日     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package jvm.study;

/**
 * @ClassName:      JvmTest04
 * @Description:    TODO
 * @author:         chenlin
 * @date:           2018年12月11日  上午10:25:40
 */
public class JvmTest04 {

	//-Xss1M
	//-Xss5M
	
	//栈深度
	private static int count;
	
	public static void recursion(){
		count++;
		recursion();
	}
	public static void main(String[] args) {
		try {
			recursion();
		} catch (Exception e) {
			System.out.println("最大count："+count);
			e.printStackTrace();
		}
	}
}
