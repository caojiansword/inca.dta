package com.inca.utils.excel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inca.result.CodeMsg;
import com.inca.result.Result;

@Controller
public class ExcelController<T,I> {
	T t;
	I i;
	@Autowired
	ExcelService<T> excelService;
	
	@RequestMapping("/import")
	public void doImport(){
		excelService.doImport();
	}
	@RequestMapping("/export")
	@ResponseBody
	public  Result<String> doExport(){
		T t = getEntity();
		Result<String> result = null;
		try {
			result = excelService.doExport(t);
		} catch (Exception e) {
			return Result.error(CodeMsg.EXPORT_ERROR);
		}
		return result;
	}
	public T getEntity() {
		// TODO Auto-generated method stub
		return t;
	}
	
	
}
