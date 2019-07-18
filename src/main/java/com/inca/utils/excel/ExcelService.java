package com.inca.utils.excel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.inca.result.Result;

@Service
public class ExcelService<T> {
	ExcelUtil<T> excelUtil;
	public void doImport() {

	}

	@SuppressWarnings("unchecked")
	public Result<String> doExport(T t) {
		List<T> list = (List<T>) getExportList();
		if(list==null||list.size()==0){
			throw new RuntimeException("没有导出数据");
		}
		String sheetName = "客户列表.xls";
		FileOutputStream out = null;
		try {
			out = new FileOutputStream("D://export/"+sheetName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("文件未找到");
		}
		Class<T> clazz = (Class<T>) t.getClass();
		excelUtil = new ExcelUtil<>(clazz);
		excelUtil.exportExcel(list, sheetName, out);
		return  Result.success("导出成功");
	}

	public List<T> getExportList() {
		return new ArrayList<>();
	}

}
