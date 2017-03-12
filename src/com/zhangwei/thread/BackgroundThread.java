package com.zhangwei.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BackgroundThread {
	public void start(){
		ExecutorService executor = Executors.newFixedThreadPool(2);
		XlsMonitorThread thread1 = new XlsMonitorThread();
		executor.execute(thread1);
		
		WorkMonitorThread thread2 = new WorkMonitorThread();
		executor.execute(thread2);
		
		executor.shutdown();
	}
}
