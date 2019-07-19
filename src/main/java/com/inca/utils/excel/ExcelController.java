package com.inca.utils.excel;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.inca.result.CodeMsg;
import com.inca.result.Result;

/**
* @ClassName: ExcelController
* @Description: TODO
* @author caojian
* @date 2019年7月19日
*
* @param <T>
* @param <I>
*/
@Controller
public class ExcelController<T> {
	T t;
	@Autowired
	ExcelService<T> excelService;
	/**
	* @Description: 弹出导入对话框
	* @param model
	* @param session
	* @return
	* @throws Exception    
	* @author caojian
	* @date 2019年7月19日 上午10:06:41 
	*/
	@RequestMapping("/importDialog")
    public String doImportDialog(Model model, HttpSession session) throws Exception {
        return "excel/importdialog";
    }
	@RequestMapping("/exportDialog")
    public String exportDialog(Model model, HttpSession session) throws Exception {
        return "excel/exportdialog";
    }
	
	@RequestMapping("/import")
	@ResponseBody
	public Result<String> doImport(@RequestParam("file") MultipartFile file){
		Result<String> result = null;
		try {
			Class<T> clazz = getClazz();
			result = excelService.doImport(file, clazz);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error(CodeMsg.getError(e.getMessage()));
		}
		return result;
	}
	
	@RequestMapping("/export")
	@ResponseBody
	public  Result<String> doExport(@RequestParam(value="file",required=false) MultipartFile file,@RequestParam(value="exportfileRealPath",required = false) String path){
		T t = getEntity();
		Result<String> result = null;
		try {
			result = excelService.doExport(null,t);
		} catch (Exception e) {
			return Result.error(CodeMsg.getError("导出异常:"+e.getMessage()));
		}
		return result;
	}
	/**
	* @Description: TODO
	* @return 获取导出实体
	* @author caojian
	* @date 2019年7月19日 上午10:31:50 
	*/
	public T getEntity() {
		return t;
	}
	
	/**
	* @Description: 获取导入类类型
	* @return    
	* @author caojian
	* @date 2019年7月19日 上午10:32:03 
	*/
	public Class<T> getClazz(){
		return null;
	}
	
}
