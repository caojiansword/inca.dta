package com.inca.result;

public class Result<T> {
	private Integer code;
	private String message;
	private T data;
	
	

	public static <T> Result<T> success(T data){
		return new Result<T>(data,CodeMsg.SUCCESS);
	}
	public static <T> Result<T> error(CodeMsg cm){
		return new Result<T>(cm);
	} 
	private Result(T data,CodeMsg cm) {
		if(cm != null) {
			this.code=cm.getCode();
			this.message = cm.getMessage();
		}
		this.data = data;
	}
	public Result(CodeMsg cm) {
		if(cm != null) {
			this.code = cm.getCode();
			this.message = cm.getMessage();
			
		}
	}
	public Integer getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public T getData() {
		return data;
	}
	
}
