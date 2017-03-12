package com.zhangwei.list;

import java.util.ArrayList;
import java.util.List;

import com.zhangwei.entity.WorkDataEntity;

public class DataList {
	private static int status = 0; 
	private static List<WorkDataEntity> workDataList = new ArrayList<WorkDataEntity>();
	
	public static List<WorkDataEntity> getWorkDataList(){
		while(true){
			if(status == 1){
				return workDataList;
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void addData(List<WorkDataEntity> dataList){
		status = 0;
		workDataList = dataList;
		status = 1;
		System.gc();
	}
}
