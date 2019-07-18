package com.inca.result;

public class CodeMsg {
	private Integer code;
	private String message;
	
	
	//调用成功
	public static CodeMsg SUCCESS = new CodeMsg(1000,"成功");
	//调用失败
	public static CodeMsg ERROR = new CodeMsg(2000,"访问失败");
	
	
	//导出异常
	public static CodeMsg EXPORT_ERROR = new CodeMsg(3000,"导出异常");
	
	
	public static CodeMsg getError(String msg){
		return new CodeMsg(0000,msg);
	}
	
	private CodeMsg(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
	
	
	public Integer getCode() {
		return code;
	}
	public String getMessage() {
		return message;
	}
	
	
}
