/**
 * FileName:         JvmTest04.java
 * @Description:     TODO
 * @author:            chenlin
 * @version            V1.0
 * Createdate:      2018��12��11��     ����10:25:40
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018��12��11��     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package jvm.study;

/**
 * @ClassName:      JvmTest04
 * @Description:    TODO
 * @author:         chenlin
 * @date:           2018��12��11��  ����10:25:40
 */
public class JvmTest04 {

	//-Xss1M
	//-Xss5M
	
	//ջ���
	private static int count;
	
	public static void recursion(){
		count++;
		recursion();
	}
	public static void main(String[] args) {
		try {
			recursion();
		} catch (Exception e) {
			System.out.println("���count��"+count);
			e.printStackTrace();
		}
	}
}
