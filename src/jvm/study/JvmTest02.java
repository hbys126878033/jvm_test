/**
 * FileName:         JvmTest02.java
 * @Description:     TODO
 * @author:            chenlin
 * @version            V1.0
 * Createdate:      2018年12月10日     下午4:09:55
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
 * @ClassName:      JvmTest02
 * @Description:    TODO
 * @author:         chenlin
 * @date:           2018年12月10日  下午4:09:55
 */
public class JvmTest02 {
	
	
	
	public static void main(String[] args) {
		/**
		 * 第一次配置：
		 * -Xms20M -Xmx20M -Xmn1M -XX:SurvivorRatio=2 -XX:+PrintGCDetails -XX:+UseSerialGC -XX:+PrintCommandLineFlags
		 * 
		 * 第二次配置：
		 * -Xms20M -Xmx20M -Xmn7M -XX:SurvivorRatio=2 -XX:+PrintGCDetails -XX:+UseSerialGC -XX:+PrintCommandLineFlags
		 * 
		 * 第三次配置：
		 * -Xms20M -Xmx20M -XX:NewRatio=2 -XX:+PrintGCDetails -XX:+UserSerialGC
		 */
		/**
		 * 
		 * -Xmn 新生代的大小 新生代大小一般是整个堆空间的1/3到1/4,对系统性能影响较大，官方推荐配置为整个堆大小的3/8
		 *  -XX:SurvivorRatio=? 设置年轻代中Eden区与Survivor（from/to）区的比值。即-XX:SurvivorRatio=Eden/from=Eden/to
		 *  -XX:NewRatio=? 年老代的比值(除去持久代)与年轻代(包括Eden和两个Survivor区),-XX:NewRatio=4表示年轻代与年老代所占比值为1:4,年轻代占整个堆栈的1/5
						Xms=Xmx并且设置了Xmn的情况下，该参数不需要进行设置
		 * 
		 * 基本策略：尽可能的将对象预留在新生代中，减少老年代的GC次数
		 * 
		 */
		byte[] b = null;
		for (int i = 0; i < 10; i++) {
			b = new byte[1*1024*1024];
			
		}
	}

}
