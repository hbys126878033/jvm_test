/**
 * FileName:         JvmTest01.java
 * @Description:     TODO
 * @author:            chenlin
 * @version            V1.0
 * Createdate:      2018年12月10日     下午2:14:16
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018年12月10日     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package jvm.study;

/**
 * @ClassName:      JvmTest01
 * @Description:    TODO
 * @author:         chenlin
 * @date:           2018年12月10日  下午2:14:16
 */



public class JvmTest01 {

	public static void main(String[] args) {
		
		/**
		 * 配置JVM：
		 * 	-XX:+PrintGC -Xms5M -Xmx20M -XX:+UseSerialGC -XX:+PrintGCDetails
		 * 
		 * 参数说明：
		 * 	-Xms5M 堆初始值5M
		 * 	-Xmx20M 堆最大值20M
		 * 新生代的配置参数：
		 *  -Xmn 新生代的大小 新生代大小一般是整个堆空间的1/3到1/4,对系统性能影响较大，官方推荐配置为整个堆大小的3/8
		 *  -XX:SurvivorRatio=? 设置年轻代中Eden区与Survivor（from/to）区的比值。即-XX:SurvivorRatio=Eden/from=Eden/to
		 *  -XX:NewRatio=? 年老代的比值(除去持久代)与年轻代(包括Eden和两个Survivor区),-XX:NewRatio=4表示年轻代与年老代所占比值为1:4,年轻代占整个堆栈的1/5
						Xms=Xmx并且设置了Xmn的情况下，该参数不需要进行设置
		 * 	-XX:+PrintGC 每次GC时打印相关信息
		 *  -XX:+UseSerialGC 每次GC时打印详细信息。
		 *  -XX:-PrintGCTimeStamps：打印每次GC的时间戳
		 *  -XX:+PrintGCDetails  每次GC时打印详细信息
		 *  -XX:+PrintCommandLineFlags 输出JVM的参数
		 *  -XX:-CITime：打印消耗在JIT编译的时间。
		 *	-XX:ErrorFile=./hs_err_pid.log：保存错误日志或数据到指定文件中。
		 *	-XX:HeapDumpPath=./java_pid.hprof：指定Dump堆内存时的路径。
		 *	-XX:-HeapDumpOnOutOfMemoryError：当首次遭遇内存溢出时Dump出此时的堆内存。
		 *	-XX:OnError=";"：出现致命ERROR后运行自定义命令。
		 *	-XX:OnOutOfMemoryError=";"：当首次遭遇内存溢出时执行自定义命令
		 *
		 * 注意：
		 * 	1.实际工作中，堆初始值大小和堆最大值大小设置成一样，从而减少垃圾回收的次数，来提高性能
		 *  -XX表示JVM参数，后面的+表示增加，-表示减少
		 *  -X表示程序的参数
		 *  
		 */
		System.out.println("max:"+Runtime.getRuntime().maxMemory()/1024/1024+"M");
		System.out.println("Total:"+Runtime.getRuntime().totalMemory()/1024/1024+"M");
		System.out.println("Free:"+Runtime.getRuntime().freeMemory()/1024/1024+"M");
		System.out.println();
		
		byte[] b = new byte[1*1024*1024];
		System.out.println("内存使用了1M");
		System.out.println("max:"+Runtime.getRuntime().maxMemory()/1024/1024+"M");
		System.out.println("Total:"+Runtime.getRuntime().totalMemory()/1024/1024+"M");
		System.out.println("Free:"+Runtime.getRuntime().freeMemory()/1024/1024+"M");
		byte[] b2 = new byte[4*1024*1024];
		System.out.println("内存使用了5M");
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
		 * JVM服务参数调优实战
			大型网站服务器案例
			承受海量访问的动态Web应用
			服务器配置：8 CPU, 8G MEM, JDK 1.6.X
			参数方案：
			-server -Xmx3550m -Xms3550m -Xmn1256m -Xss128k -XX:SurvivorRatio=6 -XX:MaxPermSize=256m -XX:ParallelGCThreads=8 -XX:MaxTenuringThreshold=0 -XX:+UseConcMarkSweepGC
			调优说明：
			-Xmx 与 -Xms 相同以避免JVM反复重新申请内存。-Xmx 的大小约等于系统内存大小的一半，即充分利用系统资源，又给予系统安全运行的空间。
			-Xmn1256m 设置年轻代大小为1256MB。此值对系统性能影响较大，Sun官方推荐配置年轻代大小为整个堆的3/8。
			-Xss128k 设置较小的线程栈以支持创建更多的线程，支持海量访问，并提升系统性能。
			-XX:SurvivorRatio=6 设置年轻代中Eden区与Survivor区的比值。系统默认是8，根据经验设置为6，则2个Survivor区与1个Eden区的比值为2:6，一个Survivor区占整个年轻代的1/8。
			-XX:ParallelGCThreads=8 配置并行收集器的线程数，即同时8个线程一起进行垃圾回收。此值一般配置为与CPU数目相等。
			-XX:MaxTenuringThreshold=0 设置垃圾最大年龄（在年轻代的存活次数）。如果设置为0的话，则年轻代对象不经过Survivor区直接进入年老代。对于年老代比较多的应用，可以提高效率；如果将此值设置为一个较大值，则年轻代对象会在Survivor区进行多次复制，这样可以增加对象再年轻代的存活时间，增加在年轻代即被回收的概率。根据被海量访问的动态Web应用之特点，其内存要么被缓存起来以减少直接访问DB，要么被快速回收以支持高并发海量请求，因此其内存对象在年轻代存活多次意义不大，可以直接进入年老代，根据实际应用效果，在这里设置此值为0。
			-XX:+UseConcMarkSweepGC 设置年老代为并发收集。CMS（ConcMarkSweepGC）收集的目标是尽量减少应用的暂停时间，减少Full GC发生的几率，利用和应用程序线程并发的垃圾回收线程来标记清除年老代内存，适用于应用中存在比较多的长生命周期对象的情况。
			内部集成构建服务器案例
			
			
			
			服务器配置：1 CPU, 4G MEM, JDK 1.6.X
			参数方案：
			-server -XX:PermSize=196m -XX:MaxPermSize=196m -Xmn320m -Xms768m -Xmx1024m
			调优说明：
			-XX:PermSize=196m -XX:MaxPermSize=196m 根据集成构建的特点，大规模的系统编译可能需要加载大量的Java类到内存中，所以预先分配好大量的持久代内存是高效和必要的。
			-Xmn320m 遵循年轻代大小为整个堆的3/8原则。
			-Xms768m -Xmx1024m 根据系统大致能够承受的堆内存大小设置即可。
		 */
	}
}
