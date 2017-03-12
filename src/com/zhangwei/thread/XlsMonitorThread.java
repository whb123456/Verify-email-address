package com.zhangwei.thread;

import com.zhangwei.group.Configuration;
import com.zhangwei.xlsx.ReadFileThread;

/**
 * ���ڶ�ȡexcel�ļ�����
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
