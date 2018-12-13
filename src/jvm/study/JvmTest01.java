/**
 * FileName:         JvmTest01.java
 * @Description:     TODO
 * @author:            chenlin
 * @version            V1.0
 * Createdate:      2018��12��10��     ����2:14:16
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
 * @ClassName:      JvmTest01
 * @Description:    TODO
 * @author:         chenlin
 * @date:           2018��12��10��  ����2:14:16
 */



public class JvmTest01 {

	public static void main(String[] args) {
		
		/**
		 * ����JVM��
		 * 	-XX:+PrintGC -Xms5M -Xmx20M -XX:+UseSerialGC -XX:+PrintGCDetails
		 * 
		 * ����˵����
		 * 	-Xms5M �ѳ�ʼֵ5M
		 * 	-Xmx20M �����ֵ20M
		 * �����������ò�����
		 *  -Xmn �������Ĵ�С ��������Сһ���������ѿռ��1/3��1/4,��ϵͳ����Ӱ��ϴ󣬹ٷ��Ƽ�����Ϊ�����Ѵ�С��3/8
		 *  -XX:SurvivorRatio=? �����������Eden����Survivor��from/to�����ı�ֵ����-XX:SurvivorRatio=Eden/from=Eden/to
		 *  -XX:NewRatio=? ���ϴ��ı�ֵ(��ȥ�־ô�)�������(����Eden������Survivor��),-XX:NewRatio=4��ʾ����������ϴ���ռ��ֵΪ1:4,�����ռ������ջ��1/5
						Xms=Xmx����������Xmn������£��ò�������Ҫ��������
		 * 	-XX:+PrintGC ÿ��GCʱ��ӡ�����Ϣ
		 *  -XX:+UseSerialGC ÿ��GCʱ��ӡ��ϸ��Ϣ��
		 *  -XX:-PrintGCTimeStamps����ӡÿ��GC��ʱ���
		 *  -XX:+PrintGCDetails  ÿ��GCʱ��ӡ��ϸ��Ϣ
		 *  -XX:+PrintCommandLineFlags ���JVM�Ĳ���
		 *  -XX:-CITime����ӡ������JIT�����ʱ�䡣
		 *	-XX:ErrorFile=./hs_err_pid.log�����������־�����ݵ�ָ���ļ��С�
		 *	-XX:HeapDumpPath=./java_pid.hprof��ָ��Dump���ڴ�ʱ��·����
		 *	-XX:-HeapDumpOnOutOfMemoryError�����״������ڴ����ʱDump����ʱ�Ķ��ڴ档
		 *	-XX:OnError=";"����������ERROR�������Զ������
		 *	-XX:OnOutOfMemoryError=";"�����״������ڴ����ʱִ���Զ�������
		 *
		 * ע�⣺
		 * 	1.ʵ�ʹ����У��ѳ�ʼֵ��С�Ͷ����ֵ��С���ó�һ�����Ӷ������������յĴ��������������
		 *  -XX��ʾJVM�����������+��ʾ���ӣ�-��ʾ����
		 *  -X��ʾ����Ĳ���
		 *  
		 */
		System.out.println("max:"+Runtime.getRuntime().maxMemory()/1024/1024+"M");
		System.out.println("Total:"+Runtime.getRuntime().totalMemory()/1024/1024+"M");
		System.out.println("Free:"+Runtime.getRuntime().freeMemory()/1024/1024+"M");
		System.out.println();
		
		byte[] b = new byte[1*1024*1024];
		System.out.println("�ڴ�ʹ����1M");
		System.out.println("max:"+Runtime.getRuntime().maxMemory()/1024/1024+"M");
		System.out.println("Total:"+Runtime.getRuntime().totalMemory()/1024/1024+"M");
		System.out.println("Free:"+Runtime.getRuntime().freeMemory()/1024/1024+"M");
		byte[] b2 = new byte[4*1024*1024];
		System.out.println("�ڴ�ʹ����5M");
		System.out.println("max:"+Runtime.getRuntime().maxMemory()/1024/1024+"M");
		System.out.println("Total:"+Runtime.getRuntime().totalMemory()/1024+"K");
		System.out.println("Free:"+Runtime.getRuntime().freeMemory()/1024/1024+"M");
		
		int aa = 0x00000000f9a00000;
		int bb = 0x00000000f9bc0000;
		//int cc = 0x00000000fa0a0000;
		System.out.println("result:"+(bb-aa)/1024+"K");
		
		/**
		 * https://www.cnblogs.com/smyhvae/p/4736162.html
		 * 
		 * JVM�����������ʵս
			������վ����������
			���ܺ������ʵĶ�̬WebӦ��
			���������ã�8 CPU, 8G MEM, JDK 1.6.X
			����������
			-server -Xmx3550m -Xms3550m -Xmn1256m -Xss128k -XX:SurvivorRatio=6 -XX:MaxPermSize=256m -XX:ParallelGCThreads=8 -XX:MaxTenuringThreshold=0 -XX:+UseConcMarkSweepGC
			����˵����
			-Xmx �� -Xms ��ͬ�Ա���JVM�������������ڴ档-Xmx �Ĵ�СԼ����ϵͳ�ڴ��С��һ�룬���������ϵͳ��Դ���ָ���ϵͳ��ȫ���еĿռ䡣
			-Xmn1256m �����������СΪ1256MB����ֵ��ϵͳ����Ӱ��ϴ�Sun�ٷ��Ƽ������������СΪ�����ѵ�3/8��
			-Xss128k ���ý�С���߳�ջ��֧�ִ���������̣߳�֧�ֺ������ʣ�������ϵͳ���ܡ�
			-XX:SurvivorRatio=6 �����������Eden����Survivor���ı�ֵ��ϵͳĬ����8�����ݾ�������Ϊ6����2��Survivor����1��Eden���ı�ֵΪ2:6��һ��Survivor��ռ�����������1/8��
			-XX:ParallelGCThreads=8 ���ò����ռ������߳�������ͬʱ8���߳�һ������������ա���ֵһ������Ϊ��CPU��Ŀ��ȡ�
			-XX:MaxTenuringThreshold=0 ��������������䣨��������Ĵ����������������Ϊ0�Ļ�������������󲻾���Survivor��ֱ�ӽ������ϴ����������ϴ��Ƚ϶��Ӧ�ã��������Ч�ʣ��������ֵ����Ϊһ���ϴ�ֵ����������������Survivor�����ж�θ��ƣ������������Ӷ�����������Ĵ��ʱ�䣬������������������յĸ��ʡ����ݱ��������ʵĶ�̬WebӦ��֮�ص㣬���ڴ�Ҫô�����������Լ���ֱ�ӷ���DB��Ҫô�����ٻ�����֧�ָ߲�����������������ڴ�������������������岻�󣬿���ֱ�ӽ������ϴ�������ʵ��Ӧ��Ч�������������ô�ֵΪ0��
			-XX:+UseConcMarkSweepGC �������ϴ�Ϊ�����ռ���CMS��ConcMarkSweepGC���ռ���Ŀ���Ǿ�������Ӧ�õ���ͣʱ�䣬����Full GC�����ļ��ʣ����ú�Ӧ�ó����̲߳��������������߳������������ϴ��ڴ棬������Ӧ���д��ڱȽ϶�ĳ��������ڶ���������
			�ڲ����ɹ�������������
			
			
			
			���������ã�1 CPU, 4G MEM, JDK 1.6.X
			����������
			-server -XX:PermSize=196m -XX:MaxPermSize=196m -Xmn320m -Xms768m -Xmx1024m
			����˵����
			-XX:PermSize=196m -XX:MaxPermSize=196m ���ݼ��ɹ������ص㣬���ģ��ϵͳ���������Ҫ���ش�����Java�ൽ�ڴ��У�����Ԥ�ȷ���ô����ĳ־ô��ڴ��Ǹ�Ч�ͱ�Ҫ�ġ�
			-Xmn320m ��ѭ�������СΪ�����ѵ�3/8ԭ��
			-Xms768m -Xmx1024m ����ϵͳ�����ܹ����ܵĶ��ڴ��С���ü��ɡ�
		 */
	}
}
