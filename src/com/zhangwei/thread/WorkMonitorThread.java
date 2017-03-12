package com.zhangwei.thread;

import com.zhangwei.entity.WorkDataEntity;
import com.zhangwei.list.DataList;

public class WorkMonitorThread implements Runnable{

	@Override
	public void run() {
		while(!Thread.interrupted()){
			for (WorkDataEntity data : DataList.getWorkDataList()) {
				System.out.println(data.toString());
			}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
