package com.inca.utils.excel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.inca.result.Result;

@Service
public abstract class ExcelService<T> {
	ExcelUtil<T> excelUtil;
	/**
	* @Description: 通用导入
	* @param file
	* @param clazz    
	* @author caojian
	* @date 2019年7月19日 上午11:20:25 
	*/
	public Result<String> doImport(MultipartFile file,Class<T> clazz) throws Exception {
		excelUtil = new ExcelUtil<>(clazz);
        InputStream input = null;
		try {
			input = file.getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<T> list = excelUtil.importExcel(null, input);
		return doImpSave(list);
	}

	/**
	* @Description: 执行保存
	* @param list    
	* @author caojian
	 * @throws Exception 
	* @date 2019年7月19日 上午10:28:12 
	*/
	public Result<String> doImpSave(List<T> list) throws Exception {
		return null;
	}

	/**
	* @Description: 通用导出
	* @param t
	* @return    
	* @author caojian
	 * @throws IOException 
	* @date 2019年7月19日 上午11:20:39 
	*/
	@SuppressWarnings("unchecked")
	public Result<String> doExport(HttpServletResponse res,T t) throws IOException {
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
			throw new RuntimeException(e.getMessage());
		}
		Class<T> clazz = (Class<T>) t.getClass();
		excelUtil = new ExcelUtil<>(clazz);
		excelUtil.exportExcel(res,list, sheetName, out);
		return  Result.success("导出成功");
	}

	public List<T> getExportList() {
		return new ArrayList<>();
	}

}
