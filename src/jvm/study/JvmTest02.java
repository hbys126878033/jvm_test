/**
 * FileName:         JvmTest02.java
 * @Description:     TODO
 * @author:            chenlin
 * @version            V1.0
 * Createdate:      2018��12��10��     ����4:09:55
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018��12��10��     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package jvm.study;

/**
 * @ClassName:      JvmTest02
 * @Description:    TODO
 * @author:         chenlin
 * @date:           2018��12��10��  ����4:09:55
 */
public class JvmTest02 {
	
	
	
	public static void main(String[] args) {
		/**
		 * ��һ�����ã�
		 * -Xms20M -Xmx20M -Xmn1M -XX:SurvivorRatio=2 -XX:+PrintGCDetails -XX:+UseSerialGC -XX:+PrintCommandLineFlags
		 * 
		 * �ڶ������ã�
		 * -Xms20M -Xmx20M -Xmn7M -XX:SurvivorRatio=2 -XX:+PrintGCDetails -XX:+UseSerialGC -XX:+PrintCommandLineFlags
		 * 
		 * ���������ã�
		 * -Xms20M -Xmx20M -XX:NewRatio=2 -XX:+PrintGCDetails -XX:+UserSerialGC
		 */
		/**
		 * 
		 * -Xmn �������Ĵ�С ��������Сһ���������ѿռ��1/3��1/4,��ϵͳ����Ӱ��ϴ󣬹ٷ��Ƽ�����Ϊ�����Ѵ�С��3/8
		 *  -XX:SurvivorRatio=? �����������Eden����Survivor��from/to�����ı�ֵ����-XX:SurvivorRatio=Eden/from=Eden/to
		 *  -XX:NewRatio=? ���ϴ��ı�ֵ(��ȥ�־ô�)�������(����Eden������Survivor��),-XX:NewRatio=4��ʾ����������ϴ���ռ��ֵΪ1:4,�����ռ������ջ��1/5
						Xms=Xmx����������Xmn������£��ò�������Ҫ��������
		 * 
		 * �������ԣ������ܵĽ�����Ԥ�����������У������������GC����
		 * 
		 */
		byte[] b = null;
		for (int i = 0; i < 10; i++) {
			b = new byte[1*1024*1024];
			
		}
	}

}
