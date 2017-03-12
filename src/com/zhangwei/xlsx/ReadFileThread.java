package com.zhangwei.xlsx;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.zhangwei.entity.WorkDataEntity;
import com.zhangwei.list.DataList;

public class ReadFileThread {
	private String fileUrl;
	
	
	public ReadFileThread(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public void readFile(){
		File file = new File(fileUrl);
		FileInputStream input = null;
		HSSFWorkbook hssfWorkbook = null;
		try {
			input = new FileInputStream(file);
			hssfWorkbook = new HSSFWorkbook(input);
			List<WorkDataEntity> dataList = new ArrayList<WorkDataEntity>();
			HSSFSheet hssfSheet = hssfWorkbook.cloneSheet(0);
			int rowCount = hssfSheet.getLastRowNum();
			for (int i = 0; i < rowCount; i++) {
				HSSFRow hssfRow = hssfSheet.getRow(i+1);
				WorkDataEntity entity = new WorkDataEntity();
				if(hssfRow == null)
					continue;
				int cells = hssfRow.getLastCellNum();
				for (int j = 0; j < cells; j++) {
					
					HSSFCell hssfCell = hssfRow.getCell(j);
					if(hssfCell == null)
						continue;
					try {
						if(j == 0){
							int index = (int)hssfCell.getNumericCellValue();
							entity.setIndex(index);
						}else if(j == 1){
							String workName = hssfCell.getStringCellValue();
							entity.setWorkName(workName);
						}else if(j == 2){
							String describe = hssfCell.getStringCellValue();
							entity.setDescribe(describe);
						}else if(j == 3){
							String level = hssfCell.getStringCellValue();
							entity.setLevel(level);
						}else if(j == 4){
							Date lastTime = hssfCell.getDateCellValue();
							entity.setLastTime(lastTime);
						}else if(j == 5){
							int status = (int)hssfCell.getNumericCellValue();
							entity.setStatus(status);
						}
						
					} catch (NumberFormatException e) {
						e.printStackTrace();
					}
				}
				dataList.add(entity);
			}
			DataList.addData(dataList);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
