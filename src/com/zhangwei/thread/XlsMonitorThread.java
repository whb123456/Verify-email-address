package com.zhangwei.thread;

import com.zhangwei.group.Configuration;
import com.zhangwei.xlsx.ReadFileThread;

/**
 * 定期读取excel文件内容
 * @author Administrator
 *
 */
public class XlsMonitorThread implements Runnable{

	@Override
	public void run() {
		while(!Thread.interrupted()){
			try {
				ReadFileThread r = new ReadFileThread(Configuration.XlsUrl);
				r.readFile();
				Thread.sleep(Configuration.readFileCycle);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
