/**
 * FileName:         JvmTest03.java
 * @Description:     TODO
 * @author:            chenlin
 * @version            V1.0
 * Createdate:      2018��12��10��     ����4:32:47
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
 * @ClassName:      JvmTest03
 * @Description:    TODO
 * @author:         chenlin
 * @date:           2018��12��10��  ����4:32:47
 */
public class JvmTest03 {

	public static void main(String[] args) {
		/**
		 * JVM���ò�����
		 * 	-Xms2M -Xmx2m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=d:/java_log.dump
		 * 
		 * 
		 * -XX:+HeapDumpOnOutOfMemoryError�����״������ڴ����ʱDump����ʱ�Ķ��ڴ档
		 * -XX:HeapDumpPath=./java_pid.hprof��ָ��Dump���ڴ�ʱ��·����
		 * 
		 * �ڴ�������ߣ�
		 * 	Memory Analyzer 1.5.0
		 * http://download.eclipse.org/mat/1.5/update-site/
		 */
		
		byte[] b = null;
		for (int i = 0; i < 5; i++) {
			b = new byte[1*1024*1024];
			
		}
		
	}
}
